// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-loops-to-batches@v1.0 defects=0}
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class BatchesPreferredOverLoopsCompliant {

    // Compliant: Efficient use of batch deletion with deleteObjects() method to delete upto 1,000 S3 objects.
    public void compliant(AmazonS3 s3Client, List<DeleteObjectsRequest.KeyVersion> keys,
                                       String bucketName) throws SdkClientException {
        if(keys.size() <= 1000) {
            final DeleteObjectsRequest deleteObjectRequest = new DeleteObjectsRequest(bucketName).withKeys(keys);
            DeleteObjectsResult deleteObjectsResult = s3Client.deleteObjects(deleteObjectRequest);
            final int numDeleted = deleteObjectsResult.getDeletedObjects().size();
            log.info("Successfully deleted: " + numDeleted);
        } else {
            throw new IllegalArgumentException("Need multiple batch calls for >1000 objects.");
        }
    }
}
// {/fact}
