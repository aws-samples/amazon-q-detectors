// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-of-free@v1.0 defects=0}

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

int compliant() {
    NAME *var;
    char buf[10];
    var = (NAME *)malloc(sizeof(struct name));

    if (var == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Compliant: Using memory safely and then freeing it.
    if (var->myname != NULL) {
        strncpy(buf, var->myname, sizeof(buf) - 1);
        buf[sizeof(buf) - 1] = '\0';
    } else {
        strcpy(buf, "N/A");
    }

    free(var);
    var = NULL;
    return 0;
}

int main() {
    return compliant();
}

// {/fact}
