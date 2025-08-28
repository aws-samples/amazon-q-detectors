// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=1}
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

void non_compliant() {
    int fd;

    // Noncompliant: Setting 777 permissions (read, write, execute for all) on the newly created file
    fd = open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO);

    if (fd == -1) {
        perror("Error opening file");
    } else {
        printf("File opened successfully with fd: %d\n", fd);
        close(fd);
    }
}

int main() {
    non_compliant();
    return 0;
}

// {/fact}
