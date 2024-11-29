// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-not-recommended-aws-credentials-classes@v1.0 defects=1}
import com.amazonaws.auth.BasicAWSCredentials;
class NotRecommendedAWSCredentialsClassesNonCompliant {
    // Noncompliant: Using not recommended classes for AWS Credentials.
    void nonCompliant() {
        System.out.println(new BasicAWSCredentials("my-access-key", "my-secret-key"));
    }
}
// {/fact}