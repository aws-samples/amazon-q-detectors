// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-temporary-file-or-directory@v1.0 defects=0}
#include <stdio.h>

void compliant() {

    // Compliant: Usage of secure function which manages the generation of unique and secure temporary files automatically.
    FILE *fp = tmpfile();

    if (fp != NULL) {
        printf("Temporary file created successfully.\n");
        fputs("This is some data written to the temporary file.\n", fp);
        fclose(fp);
    }
    else {
        printf("Failed to create temporary file.\n");
    }
}
// {/fact}
