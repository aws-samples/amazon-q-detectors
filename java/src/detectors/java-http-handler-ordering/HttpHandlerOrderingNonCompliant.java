// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-http-handler-ordering@v1.0 defects=1}
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

public class HttpHandlerOrderingNonCompliant {
    @Provides
    @Singleton
    Orchestrator nonCompliant(final List<Class<? extends InvocationInterceptor>> interceptors,
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
        // Noncompliant: Improper ordering of `JsonHttpBindingHandler` and `HttpRpcHandler` in the coral handler chain can lead to security vulnerabilities.
        handlerChain.add(new HttpRpcHandler());
        handlerChain.add(new HttpAwsJsonHandler());
        handlerChain.add(new JsonHttpBindingHandler());

        handlerChain.add(GuiceActivityHandler.create(injector, interceptors));

        final ChainHelper chainHelper = new ChainHelper();
        chainHelper.setHandlers(handlerChain);
        return new OrchestratorHelper(chainHelper, SHUTDOWN_DELAY);
    }
}
// {/fact}
