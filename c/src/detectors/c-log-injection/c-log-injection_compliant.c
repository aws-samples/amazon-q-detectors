// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-log-injection@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void redactCreditCardNumbers(char *data) {

   const char *placeholder = "************";
   char *pos = strstr(data, "1234567812345678");
   if (pos != NULL) {
       strncpy(pos, placeholder, strlen(placeholder));
       pos[strlen(placeholder)] = '\0';
   }
}

void compliant(const char *data) {

   // Compliant: Data is sanitized before logging to prevent security vulnerabilities.
   FILE *file = fopen("log.txt", "a");
   if (file != NULL) {
       char redactedData[strlen(data) + 1];
       strncpy(redactedData, data);

       redactCreditCardNumbers(redactedData);
       fputs(redactedData, file);
       fputs("\n", file);
       fclose(file);
   }
}
// {/fact}
