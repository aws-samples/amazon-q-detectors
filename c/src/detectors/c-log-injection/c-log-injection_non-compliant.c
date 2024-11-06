// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-log-injection@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

void noncompliant(const char *data) {
    //NonCompliant : user input or internal details, has been logged without proper sanitization, this can expose sensitive information.
   FILE *file = fopen("log.txt", "a");
   if (file != NULL) {
       fputs(data, file);
       fclose(file);
   }
}

int main() {
  const char *data = "Log message\n";
  noncompliant(data);
  return 0;
}
// {/fact}