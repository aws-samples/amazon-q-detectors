// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deadlock@v1.0 defects=0}
import java.util.HashMap;
import java.util.Map;

public class DeadlockRuleCompliant {

    Object syncObject1 = new Object();
    Object syncObject2 = new Object();

    // Compliant: Consistent lock acquisition order in both methods prevents potential deadlocks.
    public void compliantsync1() {
        synchronized (syncObject1) {
            synchronized (syncObject2) {
                doSomething();
            }
        }
    }

    public void compliantsync2() {
        synchronized (syncObject1) {
            synchronized (syncObject2) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {
    }

    void doSomethingElse() {
    }
}
// {/fact}
