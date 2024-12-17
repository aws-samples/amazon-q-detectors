// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-mutually-exclusive-method-calls@v1.0 defects=1}
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MutuallyExclusiveMethodCallsNoncompliant {

    // Noncompliant: `setKeySpec` and `setNumberOfBytes` are mutually exclusive; using both can lead to unexpected behavior or errors.
    private GenerateDataKeyRequest setKeySpecAndNumberOfBytes(String keySpec, Integer numberOfBytes) {
        GenerateDataKeyRequest generateRequest = new GenerateDataKeyRequest();
        generateRequest.setKeySpec(keySpec);
        generateRequest.setNumberOfBytes(numberOfBytes);
        return generateRequest;
    }
}
// {/fact}
