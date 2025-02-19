// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-awsserviceclientinitialization@v1.0 defects=1}
import com.amazonaws.services.cloudtrail.AWSCloudTrailAsyncClientBuilder;

public class AwsServiceClientInitializationNonCompliant {
    public void nonCompliant() {
        // Noncompliant: Not specifying the region explicitly could lead to poor cold-start performance.
        AWSCloudTrail awsCloudTrail = AWSCloudTrailAsyncClientBuilder.standard()
                .credentialsProvider(new ProfileCredentialsProvider("myProfile"))
                .build();
    }
}
// {/fact}
