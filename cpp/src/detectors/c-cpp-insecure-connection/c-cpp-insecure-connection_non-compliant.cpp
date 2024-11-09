// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-insecure-connection@v1.0 defects=1}
#include <iostream>

void someApi(const char* url, const char* protocol) {
    std::cout << "Connecting to " << protocol << "://" << url << std::endl;
}

void noncompliant() {
    char* url = "www.google.com";

    // Noncompliant: Opening a connection to a URL using insecure HTTP enforces SSL.
    someApi(url, "http://example.com");

}
// {/fact}
