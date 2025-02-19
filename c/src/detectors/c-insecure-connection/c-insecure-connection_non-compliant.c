// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-connection@v1.0 defects=1}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void openUrl(const char* url) {
    printf("Opening URL: %s\n", url);
}

void noncompliant() {
    // Noncompliant: Using insecure HTTP protocol instead of HTTPS.
    openUrl("http://example.com");
}

int main() {
    noncompliant();
    return 0;
}

// {/fact}
