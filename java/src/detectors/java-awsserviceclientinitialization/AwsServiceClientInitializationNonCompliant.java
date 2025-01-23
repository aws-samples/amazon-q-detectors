// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-awsserviceclientinitialization@v1.0 defects=1}
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.cloudtrail.AWSCloudTrailAsyncClientBuilder;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.datapipeline.DataPipeline;
import com.amazonaws.services.datapipeline.DataPipelineAsyncClientBuilder;
import com.amazonaws.services.route53.AmazonRoute53;
import com.amazonaws.services.route53.AmazonRoute53ClientBuilder;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sns.SnsClient;

public class AwsServiceClientInitializationNonCompliant {
    public void nonCompliant() {
        // Noncompliant: Not specifying the region explicitly could lead to poor cold-start performance.
        AWSCloudTrail awsCloudTrail = AWSCloudTrailAsyncClientBuilder.standard()
                .credentialsProvider(new ProfileCredentialsProvider("myProfile"))
                .build();
    }
}
// {/fact}