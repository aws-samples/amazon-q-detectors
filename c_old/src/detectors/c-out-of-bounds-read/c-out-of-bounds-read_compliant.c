// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-out-of-bounds-read@v1.0 defects=0}
#include <stdio.h>

int compliant() {
    int arr[5] = {1, 2, 3, 4, 5};
    int index = 2;

    // Compliant: Perform bounds checking before accessing an array.
    if (index >= 0 && index < 5) {
        int value = arr[index];
        printf("Value: %d\n", value);
    } else {
        printf("Invalid index\n");
    }
    return 0;
}
// {/fact}
