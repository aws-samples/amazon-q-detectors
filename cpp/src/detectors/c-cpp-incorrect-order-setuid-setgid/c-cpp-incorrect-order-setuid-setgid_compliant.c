// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-order-setuid-setgid@v1.0 defects=0}
#include <iostream>
#include <unistd.h>

void compliant() {
    std::cout << "Initial Real UID: " << getuid() << ", Initial Real GID: " << getgid() << std::endl;

    // Compliant: Set the `GID` before setting the `UID` to ensure proper privilege dropping.
    setgid(getgid()); 
    setuid(getuid()); 

    std::cout << "Privilege drop complete: setgid() was called before setuid() to ensure full privilege reduction." << std::endl;

    std::cout << "Final UID: " << getuid() << ", Final GID: " << getgid() << std::endl;
}

int main() {
    compliant();
    return 0;
}
// {/fact}
