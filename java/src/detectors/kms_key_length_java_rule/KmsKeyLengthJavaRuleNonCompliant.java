// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-kms-key-length@v1.0 defects=1}
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;

public class KmsKeyLengthJavaRuleNonCompliant {

    // Noncompliant: Using 128-bit keys, which is cryptographically weaker and not recommended.
    public void nonCompliant() {
        GenerateDataKeyRequest request = new GenerateDataKeyRequest().withKeySpec("AES_128");
        request.setKeySpec("AES_128");
    }
}
// {/fact}
