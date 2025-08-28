// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-default-permissions@v1.0 defects=0}
#include <fcntl.h>
#include <unistd.h>

void compliant()
{
    // Compliant: Using secure file permissions (0600) for owner-only access.
    int fd = open("sensitive_file.txt", O_CREAT | O_WRONLY, 0600);
    if (fd < 0) {
        return;
    }
    close(fd);
}
// {/fact}
