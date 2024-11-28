// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-s3-bucket-sniping@v1.0 defects=0}
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

public class S3VerifyBucketOwnerCompliant {

    // Compliant: The account that owns the bucket is specified in the request.
    public void putObjectCompliant() {
        S3Client s3Client = S3Client.create();
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket("PUT-EXAMPLE-BUCKET")
                .key("example-key")
                .expectedBucketOwner("111122223333")
                .build();
        Path path = Paths.get("put_file.txt");
        s3Client.putObject(request, path);
    }
}
// {/fact}