// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=c-insecure-use-string-copy-fn@v1.0 defects=0}
#include <string.h>
#include <stdio.h>

void compliant(const char* src, char* dest, size_t dest_size) {
    //Compliant : Applied bound checking or null terminator.
    if (strlen(src) < dest_size) {
        strcpy(dest, src);
    } else {
        printf("Source string too long for destination buffer.\n");
    }
}

int main() {
    const char* source = "Hello, World!";
    char destination[20];
    compliant(source, destination, sizeof(destination));
    printf("Destination: %s\n", destination);
    return 0;
}
// {/fact}