// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-incorrect-use-of-free-memory@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
struct data {
    int length;
    char *value;
};

int noncompliant() {
    //NonCompliant : Freed memory can lead to critical issues like data corruption or unintended code execution.
    int initial = 1000;
    struct data *data = malloc(sizeof(struct data));

    if (data == NULL) {
        printf("Memory allocation failed for data structure\n");
        return 1;
    }

    data->length = initial;
    data->value = malloc(initial);

    if (data->value == NULL) {
        printf("Memory allocation failed for value\n");
        free(data);
        return 1;
    }
    free(data);
    free(data->value);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}