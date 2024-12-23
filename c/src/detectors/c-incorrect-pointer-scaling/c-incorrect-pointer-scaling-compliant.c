// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-pointer-scaling@v1.0 defects=1}

#include <stdio.h>

int compliant1(int i)
{
    int intArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int *intPointer = intArray;

    // Compliant: Correct pointer scaling, letting pointer arithmetic handle the type size
    return *(intPointer + i);
}

int main() {
    int index = 3;
    int result = compliant1(index);
    printf("Value at index %d: %d\n", index, result);
    return 0;
}

// {/fact}
