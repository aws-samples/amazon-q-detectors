// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-integer-overflow@v1.0 defects=1}
#include <stdio.h>
#include <limits.h>

void non_compliant() {
    int a = INT_MAX / 2 + 1;
    int b = INT_MAX / 2 + 1;

    // Noncompliant: Adding two values over half the max value can cause integer overflow.
    int result = a + b;

    printf("Result: %d\n", result);
}

int main() {
    non_compliant();
    return 0;
}

// {/fact}
