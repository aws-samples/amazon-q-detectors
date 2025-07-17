// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-string-equality@v1.0 defects=1}
#include <string.h>
#include <stdio.h>


int noncompliant()
{
    char *s = "Hello";
    char ss[] = "Hello";

    // Noncompliant: Using `==` performs character comparison, which could be leveraged to affect program security.
    if (s == "World") {
        return -1;
    }
    return 0;
}
// {/fact}
