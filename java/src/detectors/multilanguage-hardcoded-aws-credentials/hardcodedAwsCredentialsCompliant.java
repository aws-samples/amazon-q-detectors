// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=multilanguage-hardcoded-aws-credentials@v1.0 defects=0}
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class hardcodedAwsCredentialsCompliant {

    // Compliant: AWS credentials are referred from system environment.
    public void compliant() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(
                System.getenv("access-key"), System.getenv("secret-key"));
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
// {/fact}
