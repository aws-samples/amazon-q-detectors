// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-object-presence@v1.0 defects=0}
import com.amazonaws.services.s3.AmazonS3;

public class ObjectPresenceCompliant {

    // Compliant: S3 object existence check performed using the efficient built-in doesObjectExist method.
    public boolean compliant(AmazonS3 s3Client, String bucketName, String key) {
        try {
            return s3Client.doesObjectExist(bucketName, key);
        } catch (Exception e) {
            return false;
        }
    }
}
// {/fact}
