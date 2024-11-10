// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-mandatory-methods@v1.0 defects=0}
import com.amazonaws.services.simplesystemsmanagement.model.PutParameterRequest;
public class MandatoryMethodsCompliant {

    // Compliant: PutParameterRequest created with mandatory method setDescription().
    public void compliant() {
        PutParameterRequest putParameterRequest = new PutParameterRequest();
        putParameterRequest.setDescription("Description");
        putParameterRequest.setName("parameterName");
    }
}
// {/fact}
