// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-equals-operator-vs-is-equal-method@v1.0 defects=0}
public class StringEqualityCheckCompliant {

    // Compliant: String equality checked using equals() method, which correctly compares string contents rather than object references.
    public void compliant(String string1, String string2) {

        if(string1!=null && string1.equals(string2)) {
            System.out.println("The strings are equal.");
        }
        else {
            System.out.println("The string 1 not present.");
        }
    }
}
// {/fact}