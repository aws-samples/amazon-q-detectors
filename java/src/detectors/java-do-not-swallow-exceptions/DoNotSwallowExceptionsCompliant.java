// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-do-not-swallow-exceptions@v1.0 defects=0}

public class DoNotSwallowExceptionsCompliant {

    // Compliant: Exception caught and re-thrown, preserving error information and allowing proper error handling.
    public void compliant() {
        try {
            example();
        } catch (Exception e) {
            throw e;
        }
    }

    void example(){

    }
}
// {/fact}