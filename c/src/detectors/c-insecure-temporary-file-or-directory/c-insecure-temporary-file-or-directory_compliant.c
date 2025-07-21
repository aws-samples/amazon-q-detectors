// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-temporary-file-or-directory@v1.0 defects=0}
#include <stdio.h>
void compliant() {
    // Compliant: Securely create a temporary file with appropriate permissions.
    int fd = open("/tmp/example", O_CREAT | O_EXCL | O_RDWR, 0600);
    if (fd == -1) {
        perror("Error creating or opening file");
        exit(EXIT_FAILURE);
    }
    close(fd);
    if (chmod("/tmp/example", 0600) == -1) {
        perror("Error setting file permissions");
        exit(EXIT_FAILURE);
    }
    if (unlink("/tmp/example") == -1) {
        perror("Error removing file");
        exit(EXIT_FAILURE);
    }
}
// {/fact}
