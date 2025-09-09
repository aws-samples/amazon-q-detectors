// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-bit-shift-checking@v1.0 defects=1}

public class BitShiftCheckingRuleNonCompliant {

    // Noncompliant: Bit Shifting would cause data loss here.
    public static int nonCompliant(long result) {
        if (result < 0) {
            return -1;
        }
        return (int) (result >>> 32);
    }
}
// {/fact}
