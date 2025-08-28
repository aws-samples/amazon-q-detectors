// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-clear-text-protocols@v1.0 defects=0}
#include <stdio.h>

void compliant()
{
    // Compliant: Using encrypted HTTPS protocol protects data transmission.
    char* https_url = "https://example.com/api/data";
    
    printf("Connecting to: %s\n", https_url);
}
// {/fact}
