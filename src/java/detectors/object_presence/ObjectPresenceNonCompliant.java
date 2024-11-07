// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-object-presence@v1.0 defects=1}
import com.amazonaws.services.s3.AmazonS3;

public class ObjectPresenceNonCompliant {

    // NonCompliant: Custom S3 object existence check implemented using `getObjectMetadata`, less efficient than built-in `doesObjectExist` method.
    public boolean nonCompliant(AmazonS3 s3Client, String bucketName, String key) {
        try {
            s3Client.getObjectMetadata(bucketName, key);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
// {/fact}
