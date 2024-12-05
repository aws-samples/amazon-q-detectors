// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-preservethreadinterruptionstatusrule@v1.0 defects=0}
import java.util.HashMap;
import java.util.Map;

public class PreserveThreadInterruptionStatusCompliant {

    // Compliant: Properly preserves thread interruption status by calling Thread.currentThread().interrupt() before throwing an exception.
    private static void compliant(int numTimes) throws RuntimeException {
        try {
            for (int i=0; i < numTimes; i++ ) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
// {/fact}
