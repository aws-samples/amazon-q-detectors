// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-out-of-bounds-read@v1.0 defects=1}
#include <stdio.h>

int noncompliant() {
    //NonCompliant : Code contains out-of-bounds read.
    int arr[5] = {1, 2, 3, 4, 5};
    int index = 5;
    int value = arr[index];
    printf("Value: %d\n", value);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}