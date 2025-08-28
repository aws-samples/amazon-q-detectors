// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-unsigned-comparison@v1.0 defects=1}

#include <stdio.h>

int bad()
{
    unsigned short uvar;

    // Noncompliant: Comparing unsigned variable to 0, which is always false.
    if (uvar < 0)
        return 1;

    return 0;
}

int main() {
    int result = bad();
    printf("Result: %d\n", result);
    return 0;
}

// {/fact}
