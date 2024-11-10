// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-swallow-exceptions@v1.0 defect=1}
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoNotSwallowExceptionsNonCompliant {

    // Noncompliant: Exception caught but neither logged nor re-thrown, potentially hiding important error information.
    public void nonCompliant() {
        try {
            example();
        } catch (Exception e) {

        }
    }

    void example(){

    }
}
// {/fact}
