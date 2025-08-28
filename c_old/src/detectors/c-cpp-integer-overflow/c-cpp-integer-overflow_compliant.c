// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-integer-overflow@v1.0 defects=0}

#include <stdio.h>
#include <limits.h>

int compliant() {
    int a = INT_MAX / 2;
    int b = INT_MAX / 2;

    // Compliant: Checking for potential overflow before addition.
    if (a > INT_MAX - b) {
        return INT_MAX;
    }
    int result = a + b;

    return result;
}

int main() {
    int result = compliant();
    printf("Result: %d\n", result);
    return 0;
}

// {/fact}
