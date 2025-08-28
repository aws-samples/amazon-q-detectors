// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cross-site-scripting@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* html_escape(const char* input) {
    size_t len = strlen(input);
    char* output = malloc(len * 6 + 1); 
    if (!output) return NULL;

    size_t j = 0;
    for (size_t i = 0; input[i]; i++) {
        switch (input[i]) {
            case '<': memcpy(&output[j], "&lt;", 4); j += 4; break;
            case '>': memcpy(&output[j], "&gt;", 4); j += 4; break;
            case '&': memcpy(&output[j], "&amp;", 5); j += 5; break;
            case '"': memcpy(&output[j], "&quot;", 6); j += 6; break;
            case '\'': memcpy(&output[j], "&#39;", 5); j += 5; break;
            default: output[j++] = input[i];
        }
    }
    output[j] = '\0';
    return output;
}

void compliant() {
    char user_input[100];
    strncpy(user_input, "<img src='x' onerror='alert(1)'>", sizeof(user_input) - 1);
    user_input[sizeof(user_input) - 1] = '\0';

    // Compliant: Sanitized string is returned and used safely.
    char* escaped = html_escape(user_input);

    if (escaped) {
        printf("<html><body>Image: %s</body></html>\n", escaped);
        free(escaped);
    }
}
// {/fact}
