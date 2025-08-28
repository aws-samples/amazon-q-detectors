// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-improper-input-validation@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

#define MAX_USERNAME 11

void compliant(char* username) {
    printf("Enter username: ");

    // Compliant: Input validation checks.
    if (fgets(username, MAX_USERNAME, stdin) != NULL) {
        size_t len = strlen(username);
        if (len > 0 && username[len-1] == '\n') {
            username[len-1] = '\0';
            len--;
        }
        if (len > 0 && len <= 10) {
            printf("Hello, %s!\n", username);
        } else {
            printf("Invalid username length!\n");
        }
    } else {
        printf("Error reading input!\n");
    }
}
// {/fact}
