// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-improper-input-validation@v1.0 defects=0}
#include <iostream>
#include <string>   

void compliant()
{
    std::string userInput;
    std::cout << "Enter input: ";
    std::getline(std::cin, userInput);

    // Compliant: Sanitize input by trimming leading and trailing whitespace.
    userInput.erase(0, userInput.find_first_not_of(" \t\r\n"));
    userInput.erase(userInput.find_last_not_of(" \t\r\n") + 1);
    std::cout << "Sanitized input is: " << userInput << std::endl;
}
// {/fact}
