// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-hard-coded-credentials@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void noncompliant()
{
    // Noncompliant: Hardcoded credentials exposed in source code.
    const char* username = "admin";
    const char* password = "password123";
    const char* api_key = "sk-1234567890abcdef1234567890abcdef";

    printf("Connecting with username: %s\n", username);
    printf("Using password: %s\n", password);
    printf("Using API key: %s\n", api_key);
}
// {/fact}
