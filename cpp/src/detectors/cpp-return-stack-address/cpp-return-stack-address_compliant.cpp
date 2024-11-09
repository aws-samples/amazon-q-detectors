// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-return-stack-address@v1.0 defects=0}
#include <iostream>

int* compliant() {
    int* ptr = new int;
    *ptr = 42;
    // Compliant: Returning a heap-allocated address
    return ptr;
}
// {/fact}