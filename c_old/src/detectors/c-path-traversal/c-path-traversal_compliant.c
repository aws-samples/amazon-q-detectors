// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-path-traversal@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compliant(int argc, char *argv[])
{
    char filename[100];

    if (argc < 2) {
        printf("Error: Please provide a filename\n");
        return 1;
    }

    // Compliant: Presence of validation on external input.
    if (strstr(argv[1], "../") != NULL) {
        printf("Error: Invalid filename\n");
        return 1;
    }

    realpath(argv[1], filename);

    FILE *fp = fopen(filename, "r");
    if(fp == NULL) {
        printf("Error opening file\n");
        return 1;
    }

    fclose(fp);
    return 0;
}
// {/fact}
