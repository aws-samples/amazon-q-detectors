// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=1}
#include <fcntl.h>  
#include <sys/stat.h> 

void noncompliant() {
    // Noncompliant: `S_IRWXU | S_IRWXG | S_IRWXO` will grant read, write, and execute permissions to the owner, group, and others to this newly created file.
    open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO);
}
// {/fact}
