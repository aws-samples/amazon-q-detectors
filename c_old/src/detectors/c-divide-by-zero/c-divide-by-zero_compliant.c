// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-divide-by-zero@v1.0 defects=0}
#include <stdio.h>
#include <stdint.h>

void compliant() {
    int a = 10;
    int b = 0;

    if (b != 0) {
        // Compliant: Denominator is validated.
        int result = a / b;
        printf("Result: %d\n", result);
    } else {
        printf("Division by zero avoided.\n");
    }
}
// {/fact}