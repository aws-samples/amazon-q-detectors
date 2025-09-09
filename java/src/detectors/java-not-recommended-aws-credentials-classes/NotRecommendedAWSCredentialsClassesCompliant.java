// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-not-recommended-aws-credentials-classes@v1.0 defects=0}
import com.amazonaws.auth.BasicSessionCredentials;
class NotRecommendedAWSCredentialsClassesCompliant {
    // Compliant: Using `BasisSessionCredentials` for credentials which is not part of NonRecommended AWS Credentials classes.
    void compliant() {
        System.out.println(new BasicSessionCredentials("my-access-key", "my-secret-key", "my-session-token"));
    }
}
// {/fact}
