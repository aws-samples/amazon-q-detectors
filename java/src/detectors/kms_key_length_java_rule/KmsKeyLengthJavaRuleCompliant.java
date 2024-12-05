// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-kms-key-length@v1.0 defects=0}
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;

public class KmsKeyLengthJavaRuleCompliant {

    // Compliant: Using 256-bit keys, which is a strong cryptographic key.
    public void compliant() {
        GenerateDataKeyRequest request = new GenerateDataKeyRequest().withKeySpec("AES_256");
        request.setKeySpec("AES_256");
    }
}
// {/fact}
