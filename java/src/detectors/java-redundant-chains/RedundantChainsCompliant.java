// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-redundant-chains@v1.0 defects=0}
import com.amazonaws.services.s3.AmazonS3;

public class RedundantChainsCompliant {
    AmazonS3 s3Client;

    // Compliant: Uses a single efficient API call to retrieve object metadata instead of chaining multiple calls.
    private String getObjectMetadataCompliant(final String bucketName, final String key) {
        return s3Client.getObjectMetadata(bucketName, key).getVersionId();
    }
}
// {/fact}
