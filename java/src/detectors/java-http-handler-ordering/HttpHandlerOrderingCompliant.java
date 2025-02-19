// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-http-handler-ordering@v1.0 defects=0}
import com.amazon.coral.guice.GuiceActivityHandler;
import com.amazon.coral.service.Handler;
import com.amazon.coral.service.HttpHandler;
import com.amazon.coral.service.HttpRpcHandler;
import com.amazon.coral.service.Log4jAwareRequestIdHandler;
import com.amazon.coral.service.Orchestrator;
import com.amazon.coral.service.PingHandler;
import com.amazon.coral.service.ServiceHandler;
import com.amazon.coral.service.helper.ChainHelper;
import com.amazon.coral.service.http.ContentHandler;
import com.amazon.coral.service.http.JsonHttpBindingHandler;

public class HttpHandlerOrderingCompliant {
    @Provides
    @Singleton
    Orchestrator compliant(final List<Class<? extends InvocationInterceptor>> interceptors,
                                          final Injector injector,
                                          final DeepHealthCheck deepHealthCheck) {

        final List<ChainComponent> handlerChain = new ArrayList<>();
        handlerChain.add(new Log4jAwareRequestIdHandler());
        handlerChain.add(new HttpHandler());
        handlerChain.add(new PingHandler(new ShallowHealthCheck()));
        final PingHandler deepPingHandler = new PingHandler(deepHealthCheck);
        deepPingHandler.setURIs(Collections.singletonList("/deep_ping"));
        handlerChain.add(deepPingHandler);

        final ContentHandler contentHandler = new ContentHandler();

        handlerChain.add(contentHandler);
        handlerChain.add(new ServiceHandler("PrimeCondorService"));
        handlerChain.add(new HttpAwsJsonHandler());
        // Compliant: Correct placement of these handlers in the Coral Handler chain is necessary to ensure that the application is properly triaged by the specified service protocol.
        handlerChain.add(new JsonHttpBindingHandler());
        handlerChain.add(new HttpRpcHandler());

        handlerChain.add(GuiceActivityHandler.create(injector, interceptors));

        final ChainHelper chainHelper = new ChainHelper();
        chainHelper.setHandlers(handlerChain);
        return new OrchestratorHelper(chainHelper, SHUTDOWN_DELAY);
    }
}
// {/fact}
