// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-bit-shift-checking@v1.0 defects=0}

public class BitShiftCheckingRuleCompliant {

    // Compliant: Safe bit shifting operation.
    public static int compliant(long result) {
        if (result < 0) {
            return -1;
        }
        return (int) (result & 0xFFFFFFFFL >>> 4);
    }
}
// {/fact}
