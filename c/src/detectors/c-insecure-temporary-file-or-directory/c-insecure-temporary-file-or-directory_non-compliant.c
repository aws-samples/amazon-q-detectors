// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-temporary-file-or-directory@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    // Noncompliant: Using insecure temporary files or directories can introduce vulnerabilities and lead to attacks.
    FILE *fp = fopen("/tmp/temporary_file", "r"); 
    if (fp != NULL) {
        fclose(fp);
    } else {
        perror("Error opening file");
    }
}
// {/fact}
