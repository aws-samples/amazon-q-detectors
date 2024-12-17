// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-wrong-var-args-position-error@v1.0 defects=1}
public class WrongVarargsPositionErrorNoncompliant {

    // Noncompliant: Incorrectly positions varargs parameter before the last argument in the method signature.
    public void nonCompliant(String s1, String... s3, String s2) {}
}
// {/fact}
