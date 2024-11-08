// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-s3-object-metadata-content-length@v1.0 defects=0}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;

public class S3ObjectMetadataContentLengthCheckCompliant {

    // Compliant: S3 putObject called with FileInputStream with content length in ObjectMetadata.
    public void compliant(AmazonS3 s3Client, File inputFile) throws FileNotFoundException {
        String s3Bucket = "sample-bucket";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(inputFile);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(inputFile.length());
            s3Client.putObject(s3Bucket, inputFile.getName(), inputStream, metadata);
        } finally {
            IOUtils.closeQuietly(inputStream, null);
        }
    }
}
// {/fact}
