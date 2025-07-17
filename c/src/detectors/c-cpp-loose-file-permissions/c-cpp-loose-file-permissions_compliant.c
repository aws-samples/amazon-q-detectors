// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-loose-file-permissions@v1.0 defects=0}
#include <sys/stat.h>
#include <fcntl.h>

void compliant()
{
    // Compliant: Setting 600 permissions restricts access to owner only
    open("myfile.txt", O_CREAT, S_IRUSR | S_IWUSR);
}
// {/fact}
