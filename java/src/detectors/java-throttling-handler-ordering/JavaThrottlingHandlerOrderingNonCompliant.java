// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-throttling-handler-ordering@v1.0 defects=1}
package example;
import com.amazon.coral.avail.flow.ThrottlingHandler;
import com.amazon.coral.guice.GuiceActivityHandler;
import com.amazon.coral.metrics.MetricsFactory;
import com.amazon.coral.service.Activity;
import com.amazon.coral.service.ExecutorHandler;
import com.amazon.coral.service.Handler;
import com.amazon.coral.service.HttpHandler;
import com.amazon.coral.service.HttpRpcHandler;
import com.amazon.coral.service.Log4jAwareRequestIdHandler;
import com.amazon.coral.service.Orchestrator;
import com.amazon.coral.service.PingHandler;
import com.amazon.coral.service.ServiceHandler;
import com.amazon.coral.service.helper.ChainHelper;

public class Example {

    @Provides
    @Singleton
    Orchestrator nonCompliant
            (
                    MetricsFactory metricsFactory,
                    ThrottlingHandler throttlingHandler,
                    Injector injector
            )
            throws Exception
    {
        List<ChainComponent> handlerChain = new ArrayList<>();
        handlerChain.add(new Log4jAwareRequestIdHandler());
        handlerChain.add(new HttpHandler());
        final PingHandler shallowPingHandler = new PingHandler
                (
                        new ShallowHealthCheck
                                (
                                        injector.getInstance(MediaStreamResourceManager.class),
                                        injector.getInstance(HealthInspector.class)
                                )
                );
        handlerChain.add(shallowPingHandler);
        PingHandler deepPingHandler = new PingHandler(new DeepHealthCheck());
        deepPingHandler.setURIs(Collections.singletonList("/deep_ping"));
        handlerChain.add(deepPingHandler);

        handlerChain.add(new ServiceHandler("SmartHomeFawkesMediaServiceVt"));

        handlerChain.add(new HttpRpcHandler());

        handlerChain.add(new GuiceActivityHandler(injector).build());
        
        // Noncompliant: ThrottlingHandler is added after the GuiceActivityHandler, potentially allowing unthrottled requests to reach the application logic.
        handlerChain.add(throttlingHandler);

        ChainHelper chainHelper = new ChainHelper();
        chainHelper.setHandlers(handlerChain);
        Orchestrator coral = new OrchestratorHelper(chainHelper, 30000);
        return coral;
    }
}
// {/fact}