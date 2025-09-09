// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-throw-exception-with-stack-trace@v1.0 defects=1}
public class ThrowExceptionWithTraceNonCompliant {

    // Noncompliant: Exception rethrown with only the message, losing original stack trace and potentially valuable debugging information.
    public void nonCompliant() throws Exception {
        try {
            doSomething();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    private void doSomething() {

    }
}
// {/fact}