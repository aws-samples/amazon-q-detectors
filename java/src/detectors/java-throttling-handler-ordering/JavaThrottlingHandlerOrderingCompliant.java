// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-throttling-handler-ordering@v1.0 defects=0}
package example;
import com.amazon.coral.avail.flow.ThrottlingHandler;
import com.amazon.coral.guice.GuiceActivityHandler;
import com.amazon.coral.service.Activity;
import com.amazon.coral.service.ChainComponent;
import com.amazon.coral.service.Handler;
import com.amazon.coral.service.HttpHandler;
import com.amazon.coral.service.HttpRpcHandler;
import com.amazon.coral.service.Log4jAwareRequestIdHandler;
import com.amazon.coral.service.Orchestrator;
import com.amazon.coral.service.PingHandler;
import com.amazon.coral.service.ServiceHandler;
import com.amazon.coral.service.helper.ChainHelper;
import com.amazon.coral.service.http.ContentHandler;
import com.amazon.coral.service.http.CrossOriginHandler;
import com.amazon.coral.throttle.api.Throttler;
import com.amazon.coral.throttle.rules.DThrottleRule;
import com.amazon.coral.throttle.rules.DThrottleRules;

public class Example {
    @Provides
    @Singleton
    Orchestrator compliant(
            final Injector injector,
            final List<Authorizer> authorizers,
            final List<Class<? extends InvocationInterceptor>> interceptors,
            @Named("GizmoThrottlingHandler") final UserHandler gizmoThrottlingHandler,
            @Named("coral.explorer.enabled") final boolean coralExplorerEnabled) throws IOException {
        List<ChainComponent> handlerChain = new ArrayList<>();
        handlerChain.add(new Log4jAwareRequestIdHandler());
        handlerChain.add(new HttpHandler());
        handlerChain.add(new CrossOriginHandler());
        handlerChain.add(new PingHandler(new ShallowHealthCheck()));

        PingHandler deepPingHandler = new PingHandler(new DeepHealthCheck());
        deepPingHandler.setURIs(Collections.singletonList("/deep_ping"));
        handlerChain.add(deepPingHandler);
        ContentHandler contentHandler = new ContentHandler.Builder()
                .withDirectories(root + "/static-content")
                .build();
        contentHandler.setServiceContent(coralExplorerEnabled);
        handlerChain.add(contentHandler);

        handlerChain.add(new ServiceHandler(appName));
        handlerChain.add(new HttpRpcHandler());
        handlerChain.add(new MetadataHandler(new com.amazon.pvproductmergeservice.GeneratedModelIndexFactory()));
        handlerChain.add(new AuthorizationHandler(authorizers));
        // Compliant: ThrottlingHandler (gizmoThrottlingHandler) is added before the GuiceActivityHandler in the handler chain.
        handlerChain.add(gizmoThrottlingHandler);
        handlerChain.add(GuiceActivityHandler.create(injector, interceptors));

        ChainHelper chainHelper = new ChainHelper();
        chainHelper.setHandlers(handlerChain);

        final long shutdownDelayInMillis = 30000;
        return new OrchestratorHelper(chainHelper, shutdownDelayInMillis);
    }
}
// {/fact}