// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-out-of-bounds-write@v1.0 defects=1}
#include <stdio.h>

void noncompliant(){
    //NonCompliant : Code contains an out-of-bounds write which may lead to security issues.
  int id_sequence[3];
  id_sequence[0] = 123;
  id_sequence[1] = 234; 
  id_sequence[2] = 345;
  id_sequence[3] = 456;
}
int main() {
   noncompliant();
   return 0;
}
// {/fact}