// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-strtok-fn@v1.0 defects=0}

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void compliant() {
    const char *static_str = "message,token";
    const char *delimiter = ",";

    // Compliant: Using a safer method for string tokenization without modifying the original string.
    const char *token_start = static_str;
    const char *token_end = strstr(static_str, delimiter);

    if (token_end != NULL) {
        size_t token_length = token_end - token_start;
        char *token = malloc(token_length + 1);

        if (token != NULL) {
            strncpy(token, token_start, token_length);
            token[token_length] = '\0';
            printf("First token: %s\n", token);
            free(token);
        } else {
            printf("Memory allocation failed\n");
        }
    } else {
        printf("No delimiter found, entire string: %s\n", static_str);
    }
}
// {/fact}
