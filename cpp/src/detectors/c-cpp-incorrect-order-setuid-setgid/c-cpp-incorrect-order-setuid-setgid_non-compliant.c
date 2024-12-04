// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-order-setuid-setgid@v1.0 defects=1}
#include <iostream>
#include <unistd.h>

void noncompliant() {
    std::cout << "Initial Real UID: " << getuid() << ", Initial Real GID: " << getgid() << std::endl;

    // Noncompliant: Setting `UID` before `GID` can lead to incomplete privilege dropping.
    setuid(getuid());
    setgid(getgid());

    std::cout << "Warning: setuid() was called before setgid(), which can lead to incomplete privilege dropping." << std::endl;

    std::cout << "Final UID: " << getuid() << ", Final GID: " << getgid() << std::endl;
}

int main() {
    noncompliant();
    return 0;
}
// {/fact}
