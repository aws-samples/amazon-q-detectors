// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-strcat-fn@v1.0 defects=1}
#include <string.h>
#include <stdio.h>

void noncompliant(char* src, char* dest) {

    // Noncompliant: Usage of `strcat` function, which can lead to buffer overflow vulnerabilities.
    strcat(dest, src);
}
// {/fact}
