// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-gets-fn@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

#define DST_BUFFER_SIZE 120

int compliant1() {
    char str[DST_BUFFER_SIZE];

    // Compliant: Using fgets() function with specified size limit, preventing buffer overflow.
    fgets(str, DST_BUFFER_SIZE, stdin);


    str[strcspn(str, "\n")] = 0;

    printf("You entered: %s\n", str);
    return 0;
}

int main() {
    printf("Enter a string (compliant version):\n");
    return compliant1();
}

// {/fact}
