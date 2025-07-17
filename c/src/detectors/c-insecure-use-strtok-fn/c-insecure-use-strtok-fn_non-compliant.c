// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-strtok-fn@v1.0 defects=1}

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Insecure - Alter static literal
void noncompliant() {
    char *static_str = "message,token";

    // Noncompliant: Using strtok on a string literal, which is undefined behavior.
    char *token = strtok(static_str, ",");

    if (token != NULL) {
        printf("First token: %s\n", token);
    }
}
// {/fact}
