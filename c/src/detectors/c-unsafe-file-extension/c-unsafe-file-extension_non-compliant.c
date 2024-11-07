// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-unsafe-file-extension@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void noncompliant() {
    //NonCompliant : Unsafe file extension vulnerabilities in your code can lead to significant security risks.
    FILE* fileIfstream = fopen("example.exe", "r");
    if (fileIfstream != NULL) {
        char buffer[1024];
        if (fgets(buffer, sizeof(buffer), fileIfstream) != NULL) {
            system(buffer);
        }
        fclose(fileIfstream);
    }
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}