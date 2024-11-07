// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-os-command-injection@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compliant(int argc, char** argv) {
    //Compliant : Sanitize  and validate such inputs before passing.
    char cat[] = "cat ";
    char *command;
    size_t commandLength;

    commandLength = strlen(cat) + 1;
    command = (char *) malloc(commandLength);
    if (command == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    strncpy(command, cat, commandLength);
    command[commandLength - 1] = '\0';

    system(command);

    free(command);
    return 0;
}

int main(int argc, char** argv) {
    return compliant(argc, argv);
}
// {/fact}