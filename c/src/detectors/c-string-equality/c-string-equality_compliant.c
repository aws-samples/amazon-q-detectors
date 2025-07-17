// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-string-equality@v1.0 defects=0}
#include <string.h>

int compliant()
{
    char *greetingPointer = "Hello";
    char greetingArray[] = "Hello";

    // Compliant: Compared the contents of two string variables using `strcmp()`.
    if (strcmp(greetingPointer, "World") == 0) {
        return -1;
    }

    return 0;
}
// {/fact}
