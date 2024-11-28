// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reassigning-synchronized-object@v1.0 defects=0}

public class ReassignSynchronizedObjectCompliant {
    Object mutex, mutex_one;

    // Compliant: Avoids re-assigning to synchronized objects in the same synchronized block.
    private void assignSynchronizingObjectCompliant() {

        synchronized (mutex) {
            mutex_one = new Object();
            doSomething(mutex);
        }
    }
    private void doSomething(Object mutex) {
    }
}
// {/fact}