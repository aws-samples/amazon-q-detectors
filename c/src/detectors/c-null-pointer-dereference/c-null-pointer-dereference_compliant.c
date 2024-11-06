// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-null-pointer-dereference@v1.0 defects=0}
#include <stdio.h>

void compliant()
    //Compliant : Pointers are always initialized before use.
{
   int *ptr = NULL;
   if (ptr != NULL)
   {
       int value = *ptr;
   }
}

int main() {
   compliant();
   return 0;
}
// {/fact}