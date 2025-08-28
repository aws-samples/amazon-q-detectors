// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-hard-coded-credentials@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void compliant()
{
    // Compliant: Reading credentials from environment variables prevents exposure.
    const char* username = getenv("DB_USERNAME");
    const char* password = getenv("DB_PASSWORD");
    const char* api_key = getenv("API_KEY");

    if (username && password && api_key) {
        printf("Connecting with credentials from environment\n");
    } else {
        fprintf(stderr, "Error: Required credentials not found in environment\n");
        exit(1);
    }
}
// {/fact}
