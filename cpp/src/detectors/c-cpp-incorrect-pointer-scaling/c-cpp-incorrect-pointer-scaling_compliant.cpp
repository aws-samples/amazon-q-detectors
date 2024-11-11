// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-pointer-scaling@v1.0 defects=0}
int compliant() {
    int intArray[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int *intPointer = intArray;
    int i = 5;
    // Compliant: Usage of valid pointer arithmetic. 
    return *(intPointer + i);
}

// {/fact}
