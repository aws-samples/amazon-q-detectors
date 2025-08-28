// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=0}

#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

void compliant() {
    int fd;

    // Compliant: Setting 770 permissions (read, write, execute for owner and group only).
    fd = open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG);

    if (fd == -1) {
        perror("Error opening file");
    } else {
        printf("File opened successfully with fd: %d\n", fd);
        close(fd);
    }
}

int main() {
    compliant();
    return 0;
}

//{/fact}
