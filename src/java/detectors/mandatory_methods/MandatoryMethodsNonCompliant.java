// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-mandatory-methods@v1.0 defects=1}
import com.amazonaws.services.simplesystemsmanagement.model.PutParameterRequest;

public class MandatoryMethodsNonCompliant {

    // NonCompliant: `PutParameterRequest` created without calling mandatory method `setDescription()`.
    public void nonCompliant() {
        PutParameterRequest putParameterRequest = new PutParameterRequest();
        putParameterRequest.setName("parameterName");
    }
}
// {/fact}
