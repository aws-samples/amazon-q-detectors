// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-of-chroot@v1.0 defects=0}
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void compliant() {

    // Compliant: The directory path is secure and proper error handling is implemented.
    const char* root_dir = "/jail/";
    uid_t non_privileged_uid = 1000; 
    if (chdir(root_dir) == -1) {
        exit(-1);
    }
    if (chroot(root_dir) == -1) {
        exit(-1);
    }
    // Drop privileges
    if (setuid(non_privileged_uid) == -1) {
        exit(-1);
    }
}
// {/fact}
