// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-os-command-injection@v1.0 defects=0}
#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

bool isValid(const std::string& filename) {
    for (char c : filename) {
        if (isspace(c) || c == ';' || c == '&' || c == '|') {
            return false;
        }
    }
    return true;
}

int compliant() {
    std::string filename;
    std::cout << "Enter a filename: ";
    std::cin >> filename;

    if (isValid(filename)) {
        std::string command = "ls " + filename;
        // Compliant: Proper validation has been followed for user input.
        system(command.c_str());
    }

    return 0;
}
// {/fact}
