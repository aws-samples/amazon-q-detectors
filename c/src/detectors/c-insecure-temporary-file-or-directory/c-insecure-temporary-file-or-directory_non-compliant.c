// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-temporary-file-or-directory@v1.0 defects=1}
#include <stdio.h>

void noncompliant3() {
   // Noncompliant: Creating a temporary file with insecure permissions.
    int fd = open("/tmp/example", O_CREAT | O_RDWR, 0666); 
    if (fd == -1) {
        perror("Error creating or opening file");
        exit(EXIT_FAILURE);
    }
    chmod("/tmp/example", 0600); 
    printf("File created or opened: /tmp/example\n");
    close(fd);
    unlink("/tmp/example");
}
// {/fact}
