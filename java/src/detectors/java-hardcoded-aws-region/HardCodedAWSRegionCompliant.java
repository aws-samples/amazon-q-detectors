// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-hardcoded-aws-region@v1.0 defects=0}
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HardCodedAWSRegionCompliant {

    private final String region = System.getenv("AMAZON_S5_PROD_R1");

    // Compliant: Uses environment variable for region instead of hardcoding.
    public AmazonS3 compliant() {
        AmazonS3 build = AmazonS3ClientBuilder.standard().withRegion(region).build();
        return build;
    }
}
// {/fact}
