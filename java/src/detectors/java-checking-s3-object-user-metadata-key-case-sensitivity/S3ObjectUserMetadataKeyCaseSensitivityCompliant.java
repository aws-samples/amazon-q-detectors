// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-s3-object-user-metadata-key-case-sensitivity@v1.0 defects=0}
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3ObjectUserMetadataKeyCaseSensitivityCompliant {

    // Compliant: S3 object user metadata key uses only lowercase letters, ensuring consistent behavior across different S3 implementations.
    public void compliant(ObjectMetadata objectMetadata) {
        objectMetadata.getUserMetaDataOf("key");
    }
}
// {/fact}
