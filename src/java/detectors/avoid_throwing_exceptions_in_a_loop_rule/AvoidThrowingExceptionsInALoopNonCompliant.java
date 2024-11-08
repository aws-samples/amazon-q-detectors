// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-throwing-exceptions-in-a-loop@v1.0 defect=1}
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AvoidThrowingExceptionsInALoopNonCompliant {

    // Noncompliant: Exception thrown and caught inside a loop, potentially impacting performance.
    public void nonCompliant(int LIMIT) {
        for (int i = 0; i < LIMIT; i++) {
            try {
                throw new Exception();
            } catch (Exception e) {
                log.error("Exception occurred: " + e);
            }
        }
    }
}
// {/fact}