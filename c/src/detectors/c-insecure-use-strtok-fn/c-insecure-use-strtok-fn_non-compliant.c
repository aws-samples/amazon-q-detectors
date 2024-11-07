// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-strtok-fn@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void noncompliant() {
    //NonCompliant : using `strtok()` tokenises strings safely via pointer without altering the original and also supports thread-safe parsing.
  char *static_str = "message,token";
  strtok(static_str, ",");
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}