// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-loose-resource-permissions@v1.0 defects=1}
#include <iostream>
#include <sys/stat.h>
#include <filesystem>
#include <unistd.h>

namespace
{
#define O_CREAT 1
#define S_IRUSR 2
#define S_IWUSR 3

    int open(int file, int permission)
    {
        return 1;
    }

    int open(int file, int permission, int mode)
    {
        return 1;
    }
}

inline int noncompliant()
{
    int FILE;
    // Noncompliant: This uses arbitrary bytes from the stack as a mode argument.
    return open(FILE, O_CREAT);
}
// {/fact}
