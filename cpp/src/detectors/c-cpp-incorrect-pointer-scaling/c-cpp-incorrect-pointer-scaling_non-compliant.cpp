// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-pointer-scaling@v1.0 defects=1}
char noncompliant() {
    int intArray[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int *intPointer = intArray;
    // Noncompliant: Usage of explicit pointer arithmetic. This introduces unnecessary complexity and can introduce errors. 
    return *(intPointer + (i * sizeof(int))); 
}
// {/fact}
