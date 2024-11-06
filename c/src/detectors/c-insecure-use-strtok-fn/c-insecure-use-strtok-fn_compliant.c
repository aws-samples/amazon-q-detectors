// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-strtok-fn@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void strsep_s() {}

int compliant() {
    //Compliant : using `strsep_s()` can leads to crashes or security issues.
  char *static_str = "message,token";
  char copy[128];
  strcpy(copy, static_str);
  strsep_s(&copy, ",", 128);
}

int main() {
   compliant();
   return 0;
}
// {/fact}