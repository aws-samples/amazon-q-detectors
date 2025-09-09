// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-avoid-invoking-string-comparison-method-with-null-string@v1.0 defects=0}

public class AvoidInvokingStringComparisonMethodWithNullStringCompliant {

    // Compliant: String x is null checked, preventing NullPointerException in equals() comparison.
    boolean compliant() {
        String x = null;
        final String y = "some";
        if(x != null) { 
            return x.equals(y);
        }
        return false;
    }
}
// {/fact}