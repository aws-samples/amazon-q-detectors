// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=1}
#include <stdio.h>

int MAX_BUFFER_SIZE = 120;

int noncompliant() {
    //NonCompliant : Using `scanf()` that can lead to buffer overflows.
    char str[MAX_BUFFER_SIZE];
    scanf("%s", str);
    printf("%.*s", MAX_BUFFER_SIZE - 1, str);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}