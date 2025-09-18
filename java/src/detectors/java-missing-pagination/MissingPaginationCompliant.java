// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-missing-pagination@v1.0 defects=0}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.glue.ml.common.domain.TransformCleanupEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingPaginationCompliant {
    private static final Logger log = LoggerFactory.getLogger(MissingPaginationCompliant.class);
    private String stage;
    private String region;

    // Compliant: Implements pagination to handle large numbers of objects safely
    public Set<String> compliant(AmazonS3 s3Client, TransformCleanupEntry transformCleanupEntry) {

        MLModelArtifact mlModelArtifact = new MLModelArtifact(
                transformCleanupEntry.getAccountId(),
                transformCleanupEntry.getTransformId(),
                "dummyFileName"
        );

        String bucketName = mlModelArtifact.bucketName(stage, region);
        String prefix = String.format("%s/%s/", transformCleanupEntry.getAccountId(), transformCleanupEntry.getTransformId());

        Set<String> deletedKeys = new HashSet<>();
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                .withBucketName(bucketName)
                .withPrefix(prefix)
                .withMaxKeys(1000); // Set a reasonable page size

        ObjectListing objectListing;
        List<DeleteObjectsRequest.KeyVersion> keysToDelete = new ArrayList<>();

        do {
            objectListing = s3Client.listObjects(listObjectsRequest);

            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                log.info("Preparing to delete file: {} from bucket: {}", objectSummary.getKey(), bucketName);

                DeleteObjectsRequest.KeyVersion keyVersion = new DeleteObjectsRequest.KeyVersion(objectSummary.getKey());
                keysToDelete.add(keyVersion);
                deletedKeys.add(objectSummary.getKey());

                // Batch delete when reaching a certain threshold or at the end of pagination
                if (keysToDelete.size() >= 1000) {
                    performBatchDelete(s3Client, bucketName, keysToDelete);
                    keysToDelete.clear();
                }
            }

            // Set the marker for the next page
            listObjectsRequest.setMarker(objectListing.getNextMarker());
        } while (objectListing.isTruncated());

        if (!keysToDelete.isEmpty()) {
            performBatchDelete(s3Client, bucketName, keysToDelete);
        }
        return deletedKeys;
    }

    private void performBatchDelete(AmazonS3 s3Client, String bucketName, List<DeleteObjectsRequest.KeyVersion> keysToDelete) {
        try {
            if (!keysToDelete.isEmpty()) {
                DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(bucketName)
                        .withKeys(keysToDelete);
                s3Client.deleteObjects(deleteObjectsRequest);
                log.info("Deleted {} objects from bucket {}", keysToDelete.size(), bucketName);
            }
        } catch (Exception e) {
            log.error("Error deleting objects from bucket {}: {}", bucketName, e.getMessage(), e);
        }
    }
}
// {/fact}
