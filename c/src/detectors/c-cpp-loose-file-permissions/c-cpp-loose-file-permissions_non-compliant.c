// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=1}
#include <sys/stat.h>
#include <fcntl.h>

void noncompliant()
{
    // Noncompliant: Setting 777 permissions allows world write and execute access
    open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO);
}
// {/fact}
