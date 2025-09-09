// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-bad-params@v1.0 defects=1}
import com.amazonaws.services.elasticmapreduce.model.ActionOnFailure;
import com.amazonaws.services.elasticmapreduce.model.StepConfig;

public class BadParamsNonCompliant {

    // Noncompliant: ActionOnFailure.TERMINATE_JOB_FLOW is outdated.
    public void nonCompliant() {
        new StepConfig().withName("sampleStepName").withActionOnFailure(ActionOnFailure.TERMINATE_JOB_FLOW);
    }
}
// {/fact}
