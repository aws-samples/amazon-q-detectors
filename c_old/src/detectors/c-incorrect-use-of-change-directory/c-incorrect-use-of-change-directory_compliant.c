// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-of-change-directory@v1.0 defects=0}
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

int validate_directory(const char* dir) {
    return 0;
}

void compliant(const char* target_dir) {

    // Compliant: Validate the target directory.
    if (validate_directory(target_dir) != 0) {
        exit(EXIT_FAILURE);
    }

    if (chdir(target_dir) != 0) {
        fprintf(stderr, "Error: Failed to change working directory: %s\n", strerror(errno));
        exit(EXIT_FAILURE);
    }
    printf("Successfully changed working directory to: %s\n", target_dir);
}
// {/fact}
