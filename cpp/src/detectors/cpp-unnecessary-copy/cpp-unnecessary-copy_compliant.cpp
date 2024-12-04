// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-unnecessary-copy@v1.0 defects=0}
#include <cstdlib>

struct Arr {
    int arr[10];
};

int compliant(bool b) {
    if (b)
    {
        Arr a;
        auto cpy = a;
        // Compliant: Modification ensures that the copy operation is necessary, as the copied instance `cpy` is used independently of the original instance `a`.
        cpy.arr[0] = 8;
        return 1;
    }
    return -1;
}
// {/fact}
