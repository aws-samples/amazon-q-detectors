// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-lambda-do-not-override-env@v1.0 defects=0}
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

@Slf4j
public abstract class LambdaDoNotOverrideEnvironmentVariablesCompliant  implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    AWSLambda client;
    private final AmazonS3 s3Client;

    public LambdaDoNotOverrideEnvironmentVariablesCompliant() {
        this.s3Client = AmazonS3ClientBuilder.defaultClient();
    }

    // Compliant: Does not override lambda's reserved environment variables in the function code.
    private void compliant  (){
        ProcessBuilder processBuilder = new ProcessBuilder();
        Map<String, String> env = processBuilder.environment();
        env.put("HANDLER", "some_value");

    }
}
// {/fact}
