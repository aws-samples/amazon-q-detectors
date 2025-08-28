// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-null-pointer-dereference@v1.0 defects=1}
#include <stdio.h>

void noncompliant()
{
    int *ptr = NULL;

    char buffer[128];
    const char *text = "Some data to copy";

    strncpy(buffer, text);
    printf("Buffer contains: %s\n", buffer);

    // Noncompliant: A potential NULL pointer attempts to access a value through a pointer that is uninitialized.
    int value = *ptr;
    printf("Value: %d\n", value);
}
// {/fact}
