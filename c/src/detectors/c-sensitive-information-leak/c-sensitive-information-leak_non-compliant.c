// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-sensitive-information-leak@v1.0 defects=1}

#include <stdio.h>
#include <stdlib.h>

void non_compliant() {
    // Noncompliant: No check present before using environment variable.
    char* path = getenv("PATH");

    char buffer[1000];

    sprintf(buffer, "Cannot find exe on path: %s", path);

    printf("%s\n", buffer);
}

int main() {
    noncompliant();
    return 0;
}

// {/fact}
