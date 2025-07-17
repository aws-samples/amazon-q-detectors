// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-pointer-scaling@v1.0 defects=1}

#include <stdio.h>

int noncompliant(int i)
{
    int intArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int *intPointer = intArray;

    // Noncompliant: Incorrect pointer scaling, multiplying the index by sizeof(int) is redundant.
    return *(intPointer + (i * sizeof(int)));
}

int main() {
    int index = 3;
    int result = noncompliant(index);
    printf("Value at index %d: %d\n", index, result);
    return 0;
}

// {/fact}
