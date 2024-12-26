// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-of-free@v1.0 defects=1}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stddef.h>
#include <sys/socket.h>

typedef struct name {
    char *myname;
    void (*func)(char *str);
} NAME;

void other_func(char *ignored) {}

int noncompliant() {
    NAME *var;
    char buf[10];
    var = (NAME *)malloc(sizeof(struct name));

    if (var == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    free(var);

    // Noncompliant: Using memory after it has been freed.
    strcpy(buf, (char*)var);

    return 0;
}

int main() {
    return noncompliant();
}

// {/fact}
