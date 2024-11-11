// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-out-of-bounds-write@v1.0 defects=0}
void compliant() {
    int arr[3] = {1, 2, 3};
    // Compliant: Accessing indices within array bounds.
    for (int i = 0; i < 3; ++i)
    {
        arr[i] = i * 2;
    }
}
// {/fact}