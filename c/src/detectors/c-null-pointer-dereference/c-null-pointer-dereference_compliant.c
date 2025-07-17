// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-null-pointer-dereference@v1.0 defects=0}
#include <stdio.h>

void compliant()
{
    int *ptr = NULL;

    char buffer[128];
    const char *text = "Some data to copy";

    strncpy(buffer, text);
    printf("Buffer contains: %s\n", buffer);

    if (ptr != NULL) {
        // Compliant: Pointers are always initialized before use.
        int value = *ptr;
        printf("Value: %d\n", value);
    } else {
        printf("Error: Attempted to dereference a NULL pointer!\n");
    }
}
// {/fact}
