// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-wrong-var-args-position-error@v1.0 defects=0}
public class WrongVarargsPositionErrorCompliant {

    // Compliant: Correctly positions varargs parameter as the last argument in the method signature.
    public void compliant(String s1, String s2, String... s3) {}
}
// {/fact}
