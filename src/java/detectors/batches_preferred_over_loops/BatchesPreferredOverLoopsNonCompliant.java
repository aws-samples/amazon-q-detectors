// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-loops-to-batches@v1.0 defects=1}
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class BatchesPreferredOverLoopsNonCompliant {

    // Noncompliant: Inefficient use of individual deleteObject() method calls in a loop instead of batch deletion.
    public void nonCompliant(AmazonS3 s3Client, List<DeleteObjectsRequest.KeyVersion> keys,
                                          String bucketName) throws SdkClientException {
        for (final DeleteObjectsRequest.KeyVersion key : keys) {
            final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, key.getKey());
            s3Client.deleteObject(deleteObjectRequest);
        }
    }
}
// {/fact}