// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=0}
#include <stdio.h>

void compliant() {
    char buf[8];

    // Compliant: `fgets` is a safer alternative
    if (fgets(buf, sizeof(buf), stdin)) {
        buf[sizeof(buf) - 1] = '\0';
        printf("Entered: %s\n", buf);
    } else {
        printf("Error reading input.\n");
    }
}
// {/fact}
