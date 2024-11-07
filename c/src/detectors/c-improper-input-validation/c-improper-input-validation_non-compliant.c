// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-improper-input-validation@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

#define MAX_USERNAME 100

void noncompliant(char* username) {
    printf("Enter username: ");
    //NonCompliant : Using user input without any validation.
    fgets(username, sizeof(username), stdin);
    printf("Hello, %s!\n", username);
}

int main() {
    char username[MAX_USERNAME];
    noncompliant(username);
    return 0;
}
// {/fact}