// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-temporary-file-or-directory@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    //NonCompliant : Using insecure temporary files or directories leads to vulnerable attacks.
    FILE *fp = fopen("/tmp/temporary_file", "r"); 
    if (fp != NULL) {
        fclose(fp);
    } else {
        perror("Error opening file");
    }
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}