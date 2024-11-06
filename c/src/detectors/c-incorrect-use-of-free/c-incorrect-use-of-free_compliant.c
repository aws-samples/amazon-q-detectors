// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-incorrect-use-of-free-memory@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

struct data {
    int length;
    char *value;
} data;

int compliant(){
    //Compliant : Ensuring proper allocation and deallocation procedures.
    int initial = 1000;
    struct data *data = malloc(sizeof(*data));
    data->length = initial;
    data->value = malloc(initial);
    free(data->value);
    free(data);
    return 0;
}

int main() {
   compliant();
   return 0;
}
// {/fact}