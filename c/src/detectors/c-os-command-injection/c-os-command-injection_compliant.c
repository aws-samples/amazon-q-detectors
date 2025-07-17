// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-os-command-injection@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int isAllowed(char* string) {
    for (int i = 0; string[i]; i++) {
        if (!(isalnum(string[i]) || string[i] == '.' || string[i] == '_')) {
            return 0;
        }
    }

    if (strstr(string, ".txt") == NULL) {
        return 0;
    }

    return 1;
}

void compliant(int argc, char** argv) {
    char cmd[15] = "/usr/bin/cat ";
    
    if (isAllowed(argv[1])) {
        // Compliant: User input is validated before being used in command construction.
        snprintf(cmd, argv[1]);
        FILE *fp = popen(cmd, 'r');
    }
}
// {/fact}