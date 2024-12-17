// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reassigning-synchronized-object@v1.0 defects=1}
public class ReassigningSynchronizedObjectNonCompliant {
    Object mutex, mutex1;

    // Noncompliant: Synchronized objects re-assigned in the same synchronized block.
    void nonCompliant() {
        synchronized (mutex) {
            mutex = new Object();
        }
    }
}
// {/fact}
