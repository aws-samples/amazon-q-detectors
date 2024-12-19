// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-custom-retries@v1.0 defects=1}
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import lombok.extern.slf4j.Slf4j;
import software.amazon.jsii.api.InvokeRequest;

@Slf4j
public class CustomRetriesNoncompliant {

    // Noncompliant: Implements manual retry logic instead of using AWS SDK's built-in retry mechanisms.
    public Bucket nonCompliant() {
        AmazonS3 awsLambdaClient = AmazonS3ClientBuilder.standard().build();
        final InvokeRequest request = new InvokeRequest();
        while (true) {
            try {
                return awsLambdaClient.createBucket("bucketname");
            } catch (AmazonServiceException e) {
                log.error("Exception: " + e);
            }
        }
    }
}
// {/fact}
