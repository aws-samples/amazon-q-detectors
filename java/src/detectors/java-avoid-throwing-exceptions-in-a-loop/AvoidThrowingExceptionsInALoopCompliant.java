// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-throwing-exceptions-in-a-loop@v1.0 defects=0}
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AvoidThrowingExceptionsInALoopCompliant {

    // Compliant: Exception handling is outside of loop, avoiding potential performance issues.
    public void compliant() {
        try {
            throw new Exception();
        } catch (Exception e) {
            log.error("Exception occurred: " + e.getStackTrace());
        }
    }
}
// {/fact}