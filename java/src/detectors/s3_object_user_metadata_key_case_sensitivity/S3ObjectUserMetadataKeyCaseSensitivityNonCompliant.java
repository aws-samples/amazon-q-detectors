// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-checking-s3-object-user-metadata-key-case-sensitivity@v1.0 defects=1}
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3ObjectUserMetadataKeyCaseSensitivityNonCompliant {

    // Noncompliant: S3 object user metadata key contains uppercase letters, which may lead to unexpected behavior due to case-sensitivity issues.
    public void nonCompliant(ObjectMetadata objectMetadata) {
        objectMetadata.getUserMetaDataOf("Key");
    }
}
// {/fact}
