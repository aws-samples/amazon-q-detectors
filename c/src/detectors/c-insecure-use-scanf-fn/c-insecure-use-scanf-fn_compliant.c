// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void compliant() {
    char buffer[8];
    
    printf("Enter a string: ");
    // Compliant: `fgets()` with size limit prevents buffer overflow.
    if (fgets(buffer, sizeof(buffer), stdin)) {
        buffer[strcspn(buffer, "\n")] = '\0';
        printf("You entered: %s\n", buffer);
    } else {
        printf("Error reading input.\n");
    }
}
// {/fact}
