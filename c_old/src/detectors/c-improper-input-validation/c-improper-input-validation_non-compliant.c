// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-improper-input-validation@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

#define MAX_USERNAME 100

void create_file(username)
{
}

void noncompliant(char* username) {
    printf("Enter username: ");

    // Noncompliant: Using user input without any validation.
    fgets(username, sizeof(username), stdin);
    create_file(username);
}
// {/fact}
