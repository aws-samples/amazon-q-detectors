// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-connection@v1.0 defects=0}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void openUrl(const char* url) {
    printf("Opening URL: %s\n", url);
}

void compliant() {
    // Compliant: Using secure HTTPS protocol.
    openUrl("https://example.com");
}

int main() {
    compliant();
    return 0;
}

// {/fact}
