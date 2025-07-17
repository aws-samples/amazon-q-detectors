// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-return-stack-address@v1.0 defects=1}
int* noncompliant() {
    // Noncompliant: Insecure because it returns the address of a local variable.
    int localVar = 42;
    return &localVar;
}
// {/fact}
