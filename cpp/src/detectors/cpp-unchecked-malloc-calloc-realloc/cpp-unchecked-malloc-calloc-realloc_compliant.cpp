// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-unchecked-malloc-calloc-realloc@v1.0 defects=0}
#include <stdlib.h>
#include <stdio.h>

#define MEMSIZE 1024

int compliant() {
    // Compliant: Call to `malloc()` with appropriate `null` validation for the `ptr` value. 
    char *ptr = (char *)malloc(MEMSIZE);

    if (ptr == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    for (int i = 0; i < MEMSIZE - 1; i++) {
        ptr[i] = 'A';
    }
    ptr[MEMSIZE - 1] = '\0';

    
    printf("Allocated memory content: %s\n", ptr);

   
    free(ptr);

    return 0;
}
// {/fact}
