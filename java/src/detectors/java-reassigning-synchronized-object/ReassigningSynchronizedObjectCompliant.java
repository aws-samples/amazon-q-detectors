// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-reassigning-synchronized-object@v1.0 defects=0}
public class ReassigningSynchronizedObjectCompliant {
    Object mutex, mutex1;

    // Compliant: Avoids re-assigning synchronizing objects in the same synchrinized block.
    void compliant() {
        synchronized (mutex) {
            mutex1 = new Object();
        }
    }
}
// {/fact}
