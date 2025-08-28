// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-ato-fn@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

void noncompliant()
{
    const char *user_input = "123abc";
    
    // Noncompliant: Using `atoi()` without error checking.
    int value = atoi(user_input);
    
    printf("Converted value: %d\n", value);
}
// {/fact}
