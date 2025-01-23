// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-client-per-invocation@v1.0 defects=1}
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClientPerInvocationNonCompliant implements RequestHandler<ScheduledEvent, Void> {

    private AWSLambda lambdaClientBad;

    private void nonCompliant() {
        // Noncompliant: Reusing clients across lambda function invocations can lead to potential security risks.
        lambdaClientBad = AWSLambdaClientBuilder.standard()
                .withRegion(System.getenv("SCHEDULER_REGION"))
                .build();
    }
}
// {/fact}