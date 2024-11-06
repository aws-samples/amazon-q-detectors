// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-out-of-bounds-write@v1.0 defects=0}
#include <stdio.h>

int compliant(){
    //Compliant : Perform bounds checking, validate input sizes and indices to ensure they stay within the allocated memory bounds.
  int id_sequence[4];

  id_sequence[0] = 123;
  id_sequence[1] = 234;
  id_sequence[2] = 345;
  id_sequence[3] = 456;

  int n = (int) sizeof(id_sequence)/sizeof(id_sequence[0]);
  for (int i = 0; i < n; ++i) {
    printf("id_sequence[%d] = %d\n", i, id_sequence[i]); 
  }
  return 0;
}

int main() {
   compliant();
   return 0;
}
// {/fact}