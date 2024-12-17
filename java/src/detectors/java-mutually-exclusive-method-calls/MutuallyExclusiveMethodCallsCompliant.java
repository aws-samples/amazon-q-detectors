// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-mutually-exclusive-method-calls@v1.0 defects=0}

import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MutuallyExclusiveMethodCallsCompliant {

    // Compliant: `setKeySpec` and `setNumberOfBytes` are used conditionally, avoiding mutually exclusive method calls.
    private GenerateDataKeyRequest conditional(String keySpec, Integer numberOfBytes) {
        GenerateDataKeyRequest generateRequest = new GenerateDataKeyRequest();
        if (numberOfBytes == 32) {
            generateRequest.setKeySpec(keySpec);
        } else {
            generateRequest.setNumberOfBytes(numberOfBytes);
        }
        return generateRequest;
    }
}
// {/fact}
