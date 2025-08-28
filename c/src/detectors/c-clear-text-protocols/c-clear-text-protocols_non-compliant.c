// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-clear-text-protocols@v1.0 defects=1}
#include <stdio.h>

void noncompliant()
{
    // Noncompliant: Using unencrypted HTTP protocol exposes data transmission.
    char* http_url = "http://example.com/api/data";
    
    printf("Connecting to: %s\n", http_url);
}
// {/fact}
