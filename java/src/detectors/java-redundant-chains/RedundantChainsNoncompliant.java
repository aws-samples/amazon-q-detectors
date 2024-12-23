// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-redundant-chains@v1.0 defects=1}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;

public class RedundantChainsNoncompliant {
    AmazonS3 s3Client;

    // Noncompliant: Uses an inefficient chain of API calls (getObject followed by getObjectMetadata) instead of a single efficient call.
    private String getObjectMetadata_getObject_getObjectMetadata(final String bucketName, final String key) {
        S3Object s3object = s3Client.getObject(bucketName, key);
        return s3object.getObjectMetadata().getVersionId();
    }
}
// {/fact}
