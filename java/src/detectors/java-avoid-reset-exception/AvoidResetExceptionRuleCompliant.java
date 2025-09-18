// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-reset-exception@v1.0 defects=0}
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import java.io.InputStream;

@Slf4j
public class AvoidResetExceptionRuleCompliant {

    // Compliant: Read limit is set on PutObjectRequest, preventing potential ResetException.
    public void compliant(String bucket, String key, InputStream content,
                                     ObjectMetadata metadata, AmazonS3 s3Client, String owner) {
        log.info("Putting content into bucket {} and key {}", bucket, key);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, content, metadata);
        putObjectRequest.setExpectedBucketOwner(owner);
        putObjectRequest.getRequestClientOptions().setReadLimit(100);
        s3Client.putObject(putObjectRequest);
    }
}
// {/fact}