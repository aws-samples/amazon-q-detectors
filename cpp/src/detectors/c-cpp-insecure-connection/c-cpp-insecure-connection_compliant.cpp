// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-insecure-connection@v1.0 defects=0}
#include <iostream>

void someApi(const char* url, const char* protocol) {
    // Simulate an API call
    std::cout << "Connecting to " << protocol << "://" << url << std::endl;
}

void compliant() {
    char* url = "www.google.com";

    // Compliant: Opening a connection to a URL using secure HTTPS enforces SSL.
    someApi(url, "https://example.com");
}
// {/fact}
