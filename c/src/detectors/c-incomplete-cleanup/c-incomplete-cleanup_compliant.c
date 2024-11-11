// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incomplete-cleanup@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

int compliant(int print) {

   FILE *f = fopen("example.txt", "w+");
   if (!f) {
       perror("fopen() failed");
       return 1;
   }
   if (print) {
       char buffer[256];
       while (fgets(buffer, 256, f)) {
           printf("%s", buffer);
       }
   }

   // Compliant: Closing files and freeing resources when they are no longer needed.
   fclose(f);
   return 0;
}
// {/fact}
