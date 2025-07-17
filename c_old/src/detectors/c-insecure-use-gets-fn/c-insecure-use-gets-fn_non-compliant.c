// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-gets-fn@v1.0 defects=1}

#include <stdio.h>
#include <string.h>

#define DST_BUFFER_SIZE 120

int noncompliant() {
    char str[DST_BUFFER_SIZE];

    // Noncompliant: Using gets() function, which is vulnerable to buffer overflow.
    gets(str);

    printf("You entered: %s\n", str);
    return 0;
}

int main() {
    printf("Enter a string (noncompliant version):\n");
    return noncompliant();
}

// {/fact}
