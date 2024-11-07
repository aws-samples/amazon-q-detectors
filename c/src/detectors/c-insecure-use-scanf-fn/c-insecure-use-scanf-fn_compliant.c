// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-scanf-fn@v1.0 defects=0}
#include <stdio.h>

void compliant() {
    //Compliant : Using `scanf()` explicitly null terminate buffer.
    char buf[8];
    scanf("%7s", buf);
    buf[7] = '\0';
}

int main() {
   compliant();
   return 0;
}
// {/fact}