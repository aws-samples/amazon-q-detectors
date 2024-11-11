// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-string-copy-fn@v1.0 defects=1}
#include <string.h>
#include <stdio.h>

void noncompliant(char* src, char* dest) {
    // Noncompliant: Using `strcpy` functions does not affirm the size of the destination array.
    strcpy(dest, src);
}
// {/fact}
