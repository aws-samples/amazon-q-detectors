// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-gets-fn@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

#define MAX_BUFFER_SIZE 120

int noncompliant() {
    //NonCompliant : Use of `gets()` is not consider buffer boundaries, posing risks of buffer overflows.
    char str[MAX_BUFFER_SIZE];
    gets(str);
    printf("%s", str);
    return 0;
}

int main() {
    return noncompliant();
}
// {/fact}