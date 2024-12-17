// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-aws-region@v1.0 defects=1}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HardCodedAWSRegionNoncompliant {

    // Noncompliant: Uses a hardcoded AWS region string instead of a configurable or environment-based approach.
    public AmazonS3 nonCompliant() {
        String region = "ap-northeast-2";
        AmazonS3 build = AmazonS3ClientBuilder.standard().withRegion(region).build();
        return build;
    }
}
// {/fact}
