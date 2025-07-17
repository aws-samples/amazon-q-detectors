// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-improper-input-validation@v1.0 defects=1}
#include <stdio.h>

void noncompliant()
{
    char username[100];
    
    printf("Enter username: ");
    fgets(username, sizeof(username), stdin);
    
    // Noncompliant: Using user input without validation.
    printf("Hello, %s!\n", username);
}
// {/fact}
