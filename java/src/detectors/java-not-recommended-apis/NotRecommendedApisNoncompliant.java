// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-not-recommended-apis@v1.0 defects=1}
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;

public class NotRecommendedApisNoncompliant {

    String bucketName = null;
    String key= null;

    // Noncompliant: Uses the older AWS SDK for Java V1, which is being phased out in favor of AWS SDK for Java V2.
    public void nonCompliant() {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
        s3Client.initiateMultipartUpload(new InitiateMultipartUploadRequest(bucketName,key));
    }
}
// {/fact}
