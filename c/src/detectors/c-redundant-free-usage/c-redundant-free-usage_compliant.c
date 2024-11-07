// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-redundant-free-usage@v1.0 defects=0}
#include <stdlib.h>

int compliant() {
    //Compliant : Avoid freeing the same memory address twice.
    char *var = malloc(sizeof(char) * 10);
    free(var);
    var = malloc(sizeof(char) * 10);
    free(var);
    return 0;
}

int main() {
   compliant();
   return 0;
}
// {/fact}