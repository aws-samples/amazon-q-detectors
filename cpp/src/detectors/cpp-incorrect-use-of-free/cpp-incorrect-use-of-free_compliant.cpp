// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-incorrect-use-of-free@v1.0 defects=0}
#include <cstdlib>

void compliant() {
    int* arr = new int[5];
    // Compliant: Not accessing array after `free`.
    free(arr);
}
// {/fact}
