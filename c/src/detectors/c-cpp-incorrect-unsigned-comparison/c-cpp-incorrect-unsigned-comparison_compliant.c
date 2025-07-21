// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-unsigned-comparison@v1.0 defects=0}

#include <stdio.h>

int correct()
{
    unsigned short int uvar;

    // Compliant: No comparison of unsigned variable to 0.
    return 0;
}

int main() {
    int result = correct();
    printf("Result: %d\n", result);
    return 0;
}

//{/fact}
