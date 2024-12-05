// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-s3-partial-encrypt@v1.0 defects=1}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class S3PartialEncryptNoncompliant {

    private AmazonS3 s3Client;
    private String uploadId;
    private List<PartETag> pendingPartETags = new ArrayList<>();
    private String bucketName;
    private String key;
    private int chunkSize;
    private boolean isLastPart;
    ObjectMetadata metadata;
    private InputStream stream;

    // Noncompliant: Using customer key encrypted data in one call and unencrypted data in another call to a server-side encrypted `S3` bucket.
    public void nonCompliant() throws Throwable {
        bucketName = "SomeBucket";
        UploadPartRequest uploadPartRequestWithKey = new UploadPartRequest()
                .withUploadId(uploadId)
                .withPartNumber(pendingPartETags.size() + 1)
                .withBucketName(bucketName).withKey(key)
                .withPartSize(chunkSize)
                .withLastPart(isLastPart)
                .withInputStream(stream)
                .withObjectMetadata(metadata);

        UploadPartRequest uploadPartRequestWithoutKey = new UploadPartRequest()
                .withUploadId(uploadId)
                .withPartNumber(pendingPartETags.size() + 1)
                .withBucketName(bucketName)
                .withPartSize(chunkSize)
                .withLastPart(isLastPart)
                .withInputStream(stream)
                .withObjectMetadata(metadata);

        if(true){
            UploadPartResult response = s3Client.uploadPart(uploadPartRequestWithKey);
        }
        else{
            UploadPartResult response = s3Client.uploadPart(uploadPartRequestWithoutKey);
        }
    }
}
// {/fact}
