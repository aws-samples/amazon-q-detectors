// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-os-command-injection@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int noncompliant(int argc, char** argv)
{
    // Noncompliant: User input passed directly to system command without validation.
    execlp("ls", argv[1], "-al", 0);
}
// {/fact}
