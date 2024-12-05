// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-deadlock@v1.0 defects=1}
import java.util.HashMap;
import java.util.Map;

public class DeadlockRuleNoncompliant {

    Object syncObject1 = new Object();
    Object syncObject2 = new Object();

    // Noncompliant: Inconsistent lock acquisition order in methods can lead to potential deadlocks.
    public void noncompliantsync1() {
        synchronized (syncObject1) {
            synchronized (syncObject2) {
                doSomething();
            }
        }
    }

    public void noncompliantsync2() {
        synchronized (syncObject2) {
            synchronized (syncObject1) {
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
