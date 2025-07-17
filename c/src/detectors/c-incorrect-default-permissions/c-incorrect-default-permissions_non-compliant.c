// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-default-permissions@v1.0 defects=1}
#include <fcntl.h>
#include <unistd.h>

void noncompliant()
{
    // Noncompliant: Using overly permissive file permissions (0777).
    int fd = open("sensitive_file.txt", O_CREAT | O_WRONLY, 0777);
    if (fd < 0) {
        return;
    }
    close(fd);
}
// {/fact}
