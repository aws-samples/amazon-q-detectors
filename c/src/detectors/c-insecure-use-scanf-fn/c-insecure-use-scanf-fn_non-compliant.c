// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    char small_buffer[8];
    
    printf("Enter a long string: ");
    // Noncompliant: `scanf()` without bounds checking can overflow small buffers.
    scanf("%s", small_buffer);
    
    printf("You entered: %s\n", small_buffer);
}
// {/fact}
