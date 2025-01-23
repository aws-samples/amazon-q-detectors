// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-client-per-invocation@v1.0 defects=0}
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClientPerInvocationCompliant implements RequestHandler<ScheduledEvent, Void> {

    private AWSLambda lambdaClientBad;

    private static final AWSLambda lambdaClient = AWSLambdaClientBuilder.standard()
            .withRegion(System.getenv("SCHEDULER_REGION"))
            .build();
    // Compliant: Using constructor which allows to keep alive and reuse HTTP connections could improve the performance of the lambda function.
    private void compliant() {

    }
}
// {/fact}
