// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-divide-by-zero@v1.0 defects=1}
#include <stdio.h>
#include <stdint.h>

void noncompliant() {
    int a = 10;
    int b = 0;
    // Noncompliant: Divide-by-zero condition.
    int result = a / b;
    printf("Result: %d\n", result);
}
// {/fact}
