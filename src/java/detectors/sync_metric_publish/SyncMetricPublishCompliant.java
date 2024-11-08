// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-sync-metric-publish@v1.0 defects=0}
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchAsync;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClientBuilder;
import com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricDataResult;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;

import java.util.concurrent.Future;

public class SyncMetricPublishCompliant implements RequestHandler<ScheduledEvent, Void> {

    private final AmazonCloudWatchAsync cloudWatchAsync;

    public SyncMetricPublishCompliant() {
        cloudWatchAsync = AmazonCloudWatchAsyncClientBuilder.defaultClient();
    }

    // Compliant: Metrics logged asynchronously for post-processing with putMetricDataAsync() method, avoiding synchronous CloudWatch calls that could impact Lambda execution time.
    @Override
    public Void compliant(ScheduledEvent scheduledEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        final long startTime = System.currentTimeMillis();
        doSomething(scheduledEvent, context);
        final long endTime = System.currentTimeMillis();
        final long timeElapsed = endTime - startTime;
        PutMetricDataRequest putMetricDataRequest = new PutMetricDataRequest();
        MetricDatum metricDatum = new MetricDatum().withMetricName("TIME_ELAPSED")
                .withUnit(StandardUnit.Milliseconds).withValue((double) timeElapsed);
        putMetricDataRequest.withNamespace("EXAMPLE_NAMESPACE").withMetricData(metricDatum);
        logger.log("Metrics: " + metricDatum);
        Future<PutMetricDataResult> future = cloudWatchAsync.putMetricDataAsync(putMetricDataRequest,
                new AsyncHandler<PutMetricDataRequest, PutMetricDataResult>() {
                    @Override
                    public void onSuccess(PutMetricDataRequest request, PutMetricDataResult result) {
                        context.getLogger().log("Successfully published metric data");
                    }

                    @Override
                    public void onError(Exception e) {
                        context.getLogger().log("Error publishing metric data: " + e.getMessage());
                    }
                });
        return null;
    }

    private void doSomething(ScheduledEvent scheduledEvent, Context context) {

    }
}
// {/fact}
