// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-incorrect-use-sscanf-fn@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

int noncompliant() {
    //NonCompliant : Avoid using `sscanf()` for number conversions.
    const char *float_str = "3.1415926535897932384626433832";
    int read;
    float var;
    read = sscanf(float_str, "%f", &var);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}