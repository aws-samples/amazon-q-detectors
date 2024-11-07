// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-strcat-fn@v1.0 defects=1}
#include <string.h>
#include <stdio.h>

void noncompliant(char* src, char* dest) {
    //NonCompliant : Using `strcat` functions, Which can lead to buffer overflow vulnerabilities.
 strcat(dest, src);
}
int main() {
  char src[50] = "Hello ";
  char dest[100] = "World";
  noncompliant(src, dest);
  return 0;
}
// {/fact}