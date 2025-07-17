// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-improper-input-validation@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void compliant()
{
    char username[100];
    
    printf("Enter username: ");
    fgets(username, sizeof(username), stdin);
    
    // Compliant: Validating input length before use.
    if (strlen(username) > 0 && strlen(username) <= 50) {
        printf("Hello, %s!\n", username);
    } else {
        printf("Invalid username length!\n");
    }
}
// {/fact}
