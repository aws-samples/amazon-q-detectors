// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reassigning-synchronized-object@v1.0 defects=1}

public class ReassignSynchronizedObjectNoncompliant {
    Object mutex, mutex_one;

    // Noncompliant: Synchronized objects re-assigned in the same synchronized block.
    private void assignSynchronizedObjectNoncompliant() {
        synchronized (mutex) {
            mutex = new Object();
            doSomething(mutex);
        }
    }
    private void doSomething(Object mutex) {
    }
}
// {/fact}
