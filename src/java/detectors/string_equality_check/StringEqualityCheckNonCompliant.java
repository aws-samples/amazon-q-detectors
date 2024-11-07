// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-equals-operator-vs-is-equal-method@v1.0 defects=1}
public class StringEqualityCheckNonCompliant {

    // NonCompliant: String equality checked using `==` operator, which compares object references instead of string contents.
    public void nonCompliant(String string1, String string2) {
        if(string1 == string2) {
            System.out.println("The strings are equal.");
        }
    }
}
// {/fact}
