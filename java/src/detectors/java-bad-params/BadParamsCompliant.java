// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-bad-params@v1.0 defects=0}
import com.amazonaws.services.elasticmapreduce.model.ActionOnFailure;
import com.amazonaws.services.elasticmapreduce.model.StepConfig;

public class BadParamsCompliant {

    // Compliant: ActionOnFailure.TERMINATE_CLUSTER is used.
    public void compliant() {
        new StepConfig().withName("sampleStepName").withActionOnFailure(ActionOnFailure.TERMINATE_CLUSTER);
    }
}
// {/fact}
