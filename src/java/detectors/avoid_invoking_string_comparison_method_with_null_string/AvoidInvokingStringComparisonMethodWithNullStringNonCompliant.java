// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-invoking-string-comparison-method-with-null-string@v1.0 defect=1}

public class AvoidInvokingStringComparisonMethodWithNullStringNonCompliant {

    // NonCompliant: Potential NullPointerException when invoking equals() on null String x.
    boolean nonCompliant() {
        String x = null;
        final String y = "some";
        if(x.equals(y)) {
            return true;
        }
        return false;
    }
}
// {/fact}