// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-path-traversal@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    char file_path[256];
    printf("Enter the file path: ");
    scanf("%s", file_path);

    // Noncompliant: User input to specify file paths for reading or writing operation without proper validation.
    FILE *file = fopen(file_path, "r");
    if (file) {
        printf("File opened successfully!\n");
        fclose(file);
    } else {
        printf("Failed to open the file.\n");
    }
}
// {/fact}
