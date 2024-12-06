// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-unnecessary-copy@v1.0 defects=1}
#include <cstdlib>

struct Arr {
    int arr[10];
};

int noncompliant(bool b) {
    if (b)
    {
        Arr a;
        // Noncompliant: Unnecessary copy operation because it creates a copy conditionally based on the value of `b`.
        auto cpy = a;
        return 1;
    }
    return -1;
}
// {/fact}
