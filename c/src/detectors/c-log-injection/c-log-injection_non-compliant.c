// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-log-injection@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

void noncompliant(const char *data) {

   // Noncompliant: Logging of user input without proper sanitization which can expose sensitive information.
   FILE *file = fopen("log.txt", "a");
   if (file != NULL) {
       fputs(data, file);
       fclose(file);
   }
}
// {/fact}
