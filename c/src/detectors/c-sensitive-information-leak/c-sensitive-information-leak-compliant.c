// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-sensitive-information-leak@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

void compliant() {
    // Compliant: Check present before using environment variable.
    const char* path = getenv("PATH");

    char buffer[1000];

    if (path != NULL) {
        snprintf(buffer, sizeof(buffer), "Cannot find exe on path: %s", path);
        printf("%s\n", buffer);
    } else {
        printf("PATH environment variable is not set.\n");
    }
}

int main() {
    compliant();
    return 0;
}

// {/fact}
