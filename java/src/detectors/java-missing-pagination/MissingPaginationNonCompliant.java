// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=java-missing-pagination@v1.0 defects=1}
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
public class MissingPaginationNonCompliant {

    // Noncompliant : Fetches all objects without pagination, which can cause performance issues and potential memory overflow for large numbers of objects.
    public Set<String> nonCompliant(AmazonS3 s3Client, TransformCleanupEntry transformCleanupEntry) {
        MLModelArtifact mlModelArtifact = new MLModelArtifact(
                transformCleanupEntry.getAccountId(),
                transformCleanupEntry.getTransformId(),
                "dummyFileName"
        );

        String bucketName = mlModelArtifact.bucketName(stage, region);
        String key = String.format("%s/%s/", transformCleanupEntry.getAccountId(), transformCleanupEntry.getTransformId());

        // Potential vulnerability: Fetches all objects at once without pagination
        List<S3ObjectSummary> s3ObjectSummaries = s3Client.listObjects(bucketName, key).getObjectSummaries();

        List<DeleteObjectsRequest.KeyVersion> keys = new ArrayList<>();
        for (S3ObjectSummary s3ObjectSummary : s3ObjectSummaries) {
            log.info("Deleting file : {} with bucketName : {}", s3ObjectSummary.getKey(), bucketName);
            keys.add(new DeleteObjectsRequest.KeyVersion(s3ObjectSummary.getKey()));
        }

        if (!keys.isEmpty()) {
            s3Client.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys));
        }
        return new HashSet<>();
    }

}
// {/fact}
