// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-return-stack-address@v1.0 defects=1}
#include <iostream>

int* noncompliant() {
    int localVar = 42;
    // Noncompliant: Returning a stack address.
    return &localVar;
}
// {/fact}