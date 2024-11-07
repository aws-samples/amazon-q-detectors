// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-string-equality@v1.0 defects=1}
#include <string.h>
#include <stdio.h>

char *s = "Hello";
char ss[] = "Hello";
 //NonCompliant : Using `==` performs character comparison, Which could be leveraged to affect program security.
int noncompliant()
{
    if (s == "World") {
        return -1;
    }
    return 0;
}

int main() {
    int result = noncompliant();
    printf("Result: %d\n", result);
    return 0;
}
// {/fact}