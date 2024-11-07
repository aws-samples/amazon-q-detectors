// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-incorrect-use-of-change-directory@v1.0 defects=1}
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int noncompliant() {
    //NonCompliant : Directly using environment variable.
    char *path = getenv("USER_DIR");
    chdir(path);
    return 0;
}

int main() {
   noncompliant();
   return 0;
}
// {/fact}