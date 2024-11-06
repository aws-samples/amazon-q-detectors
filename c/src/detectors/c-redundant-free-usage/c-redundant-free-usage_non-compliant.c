// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-redundant-free-usage@v1.0 defects=1}
#include <stdlib.h>

int noncompliant() {
    //NonCompliant : Calling `free(var)` twice on the same memory address, which may leads to program crashes.
    char *var = malloc(sizeof(char) * 10);
    free(var);
    free(var);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}