// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-null-check-cache-response-metadata@v1.0 defects=0}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.AmazonWebServiceRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullCheckCacheResponseMetadataCompliant {

    // Compliant: getCachedResponseMetadata result null-checked before use, preventing NullPointerException.
    public void compliant(AmazonWebServiceRequest request, AmazonS3 amazonS3Client) {
        S3ResponseMetadata responseMetadata = amazonS3Client.getCachedResponseMetadata(request);
        if (responseMetadata != null) {
            log.info("Request ID: " + responseMetadata.getRequestId());
        } else {
            log.info("Could not obtain cached metadata.");
        }
    }
}
// {/fact}
