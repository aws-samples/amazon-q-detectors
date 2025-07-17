// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-ato-fn@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

void compliant()
{
    const char *user_input = "123abc";
    char *endptr;
    
    // Compliant: Using `strtol()` with proper error checking.
    errno = 0;
    long value = strtol(user_input, &endptr, 10);
    
    if (errno != 0 || endptr == user_input || *endptr != '\0') {
        printf("Invalid input: %s\n", user_input);
        return;
    }
    
    printf("Converted value: %ld\n", value);
}
// {/fact}
