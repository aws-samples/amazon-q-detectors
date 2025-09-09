// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-hardcoded-aws-credentials@v1.0 defects=1}
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class hardcodedAwsCredentialsNonCompliant {

    // Noncompliant: Hardcoded AWS credentials are used.
    public void nonCompliant() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("ASIAJLVYNHUWCEXAMPLE", "foo");
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
// {/fact}
