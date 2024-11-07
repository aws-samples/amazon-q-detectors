// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-os-command-injection@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int noncompliant(int argc, char **argv) {
    //NonCompliant : Passing an untrusted input to a method that dynamically executes a command.
    char cat[] = "cat ";
    char *command;
    size_t commandLength;

    commandLength = strlen(cat) + strlen(argv[1]) + 1;
    command = (char *) malloc(commandLength);
    strncpy(command, cat, commandLength);

    strncat(command, argv[1], (commandLength - strlen(cat) - 1));
    system(command);
    free(command);
    return 0;
}

int main(int argc, char **argv) {
    return noncompliant(argc, argv);
}
// {/fact}