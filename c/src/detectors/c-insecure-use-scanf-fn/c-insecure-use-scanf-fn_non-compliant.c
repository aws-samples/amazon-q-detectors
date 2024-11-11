// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    char str[120];
    // Noncompliant: Usage of `scanf()` can lead to 'buffer overflow' vulnerabilities.
    scanf("%s", str);
}
// {/fact}
