// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-insecure-use-strcat-fn@v1.0 defects=0}
#include <string.h>
#include <stdio.h>

void compliant(char* src, char* dest, int dest_size) {
   // Compliant: Applied bound checking or null terminator.
   int l = strlen(src);
   if (l < dest_size) {
       strcat(dest, src);
   }
}
// {/fact}
