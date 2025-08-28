// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-bitwise-operator-on-signed-operand@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

void compliant()
{
    unsigned int x = 20;
    unsigned int y = 5;
    
    // Compliant: Bitwise AND operation on unsigned integers.
    unsigned int result = x & y;
    
    printf("Result: %u\n", result);
}
// {/fact}
