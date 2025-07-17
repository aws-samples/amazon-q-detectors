// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-order-setuid-setgid@v1.0 defects=0}
#include <stdio.h>
#include <unistd.h>

void process_log1() {
    printf("Test\n");
}

void process_log2() {
    printf("Test\n");
}

void compliant() {
   // Compliant: setgid() is called before setuid(), ensuring proper privilege dropping.
    setgid(getgid());
    setuid(getuid());
}

int main() {
    printf("Before dropping privileges:\n");
    printf("UID: %d, GID: %d\n", getuid(), getgid());

    compliant();

    printf("After dropping privileges:\n");
    printf("UID: %d, GID: %d\n", getuid(), getgid());

    return 0;
}

// {/fact}
