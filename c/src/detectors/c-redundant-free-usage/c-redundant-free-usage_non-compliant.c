// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-redundant-free-usage@v1.0 defects=1}
#include <stdlib.h>

int noncompliant() {
    char *var = malloc(sizeof(char) * 10);
    free(var);

    // Noncompliant: Calling `free(var)` twice on the same memory address, which may lead to program crashes.
    free(var);
    return 0;
}
// {/fact}
