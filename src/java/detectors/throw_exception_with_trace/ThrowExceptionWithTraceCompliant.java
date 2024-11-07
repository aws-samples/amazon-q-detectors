// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-throw-exception-with-stack-trace@v1.0 defects=0}
public class ThrowExceptionWithTraceCompliant {

    // Compliant: Exception rethrown with original exception as cause, preserving stack trace for better debugging and error analysis.
    public void compliant() throws Exception {
        try {
            doSomething();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }
    }

    private void doSomething() {

    }
}
// {/fact}
