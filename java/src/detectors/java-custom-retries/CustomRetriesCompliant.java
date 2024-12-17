// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-custom-retries@v1.0 defects=0}
import com.amazonaws.ClientConfiguration;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomRetriesCompliant {

    // Compliant: Uses custom retry policy with ClientConfiguration for AWS SDK operations.
    public Bucket compliant() {
        ClientConfiguration clientConfiguration = new ClientConfiguration()
                .withRetryPolicy(RetryPolicy.builder().withMaxErrorRetry(5)
                        .build());
        AmazonS3 awsLambdaClient = AmazonS3ClientBuilder.standard()
                .withClientConfiguration(clientConfiguration)
                .build();

        final InvokeRequest request = new InvokeRequest();
        return awsLambdaClient.createBucket("deded");
    }
}
// {/fact}
