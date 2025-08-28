// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-bitwise-operator-on-signed-operand@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

void noncompliant()
{
    int x = -20;
    int y = 5;
    
    // Noncompliant: Bitwise AND operation on signed integers.
    int result = x & y;
    
    printf("Result: %d\n", result);
}
// {/fact}
