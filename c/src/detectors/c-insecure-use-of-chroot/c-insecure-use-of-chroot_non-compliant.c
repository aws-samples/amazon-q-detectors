// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-of-chroot@v1.0 defects=1}
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void noncompliant(){

    // Noncompliant: Use of the `chroot` function, which may lead to security vulnerabilities.
    const char* root_dir = "/jail/";
    chroot(root_dir);
}
// {/fact}
