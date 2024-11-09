// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=0}
#include <fcntl.h>    
#include <sys/stat.h> 

void compliant() {
    // Compliant: `S_IRWXU | S_IRWXG` will grant read, write, and execute permissions to the owner and group to this newly created file.
    open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG);
}
// {/fact}
