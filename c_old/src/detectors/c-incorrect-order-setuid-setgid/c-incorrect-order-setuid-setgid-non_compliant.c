// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-order-setuid-setgid@v1.0 defects=1}
#include <stdio.h>
#include <unistd.h>

void process_log1() {
    printf("Test\n");
}

void process_log2() {
    printf("Test\n");
}

void noncompliant() {

    // Noncompliant: setgid() is called after setuid(), which may fail to drop privileges properly.
    setuid(getuid());
    setgid(getgid());
}

int main() {
    printf("Before dropping privileges:\n");
    printf("UID: %d, GID: %d\n", getuid(), getgid());

    noncompliant();

    printf("After dropping privileges:\n");
    printf("UID: %d, GID: %d\n", getuid(), getgid());

    return 0;
}

// {/fact}
