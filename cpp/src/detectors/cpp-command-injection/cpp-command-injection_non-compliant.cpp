// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-command-injection@v1.0 defects=1}
#include <cstring>
#include <cstdlib>

#define CMD_MAX 256 

int noncompliant(int argc, char **argv) {
    if (argc < 2) {
        return -1;
    }

    char cmd[CMD_MAX] = "/usr/bin/cat ";
    
    strcat(cmd, argv[1]); 
    
    // Noncompliant: Concatenation of untrusted data is done above which is used directly to execute a command.
    system(cmd);

    return 0;
}
// {/fact}
