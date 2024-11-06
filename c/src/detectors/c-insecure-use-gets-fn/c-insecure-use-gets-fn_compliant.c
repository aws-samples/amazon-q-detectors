// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-gets-fn@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

int MAX_BUFFER_SIZE = 120;

int compliant() {
    //Compliant : Use secure functions like `fgets()` or `gets_s()` which ensure buffer limits.
    char str[MAX_BUFFER_SIZE];
    fgets(str, MAX_BUFFER_SIZE, stdin);
    printf("%s", str);
    return 0;
}

int main() {
   compliant();
   return 0;
}
// {/fact}