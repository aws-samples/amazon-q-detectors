// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-null-pointer-dereference@v1.0 defects=1}
#include <stdio.h>

void noncompliant()
    //NonCompliant : A potential NULL pointer attempts to access a value through a pointer that is uninitialized.
{
   int *ptr;
   int value = *ptr;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}