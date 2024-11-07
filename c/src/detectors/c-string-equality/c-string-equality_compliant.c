// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-string-equality@v1.0 defects=0}
#include <string.h>

    char *s = "Hello";
    char ss[] = "Hello";
//Compliant : Compared the contents of two string variables using the `strcmp()`.
int compliant()
{
    if (strcmp(s, "World") == 0) {

        return -1;
    }
return 0;
}

int main() {
   compliant();
   return 0;
}
// {/fact}