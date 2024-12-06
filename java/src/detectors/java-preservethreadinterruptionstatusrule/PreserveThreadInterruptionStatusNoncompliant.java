// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-preservethreadinterruptionstatusrule@v1.0 defects=1}
import java.util.HashMap;
import java.util.Map;

public class PreserveThreadInterruptionStatusNoncompliant {

    // Noncompliant: Catches InterruptedException but fails to preserve thread interruption status before rethrowing.
    private static void nonCompliant(int numTimes) throws RuntimeException {
        try {
            for (int i=0; i < numTimes; i++ ) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
// {/fact}
