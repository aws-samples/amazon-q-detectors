// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-unsafe-file-extension@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void compliant() {

    // Compliant: `txt` file extension is safe.
    const char* filename = "example.txt";
    const char* ext = strrchr(filename, '.');

    if (ext && strcmp(ext, ".txt") == 0) {
        FILE* fileIfstream = fopen(filename, "r");
        if (fileIfstream != NULL) {
            fclose(fileIfstream);
        }
    }
}
// {/fact}
