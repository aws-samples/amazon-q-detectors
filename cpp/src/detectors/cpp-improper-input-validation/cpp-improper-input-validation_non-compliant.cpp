// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-improper-input-validation@v1.0 defects=1}
#include <iostream>
#include <string> 

void noncompliant()
{
    std::string userInput;
    std::cout << "Enter input: ";
    std::getline(std::cin, userInput);
    
    // Noncompliant: User input is used without validation.
    std::cout << " input is: " << userInput << std::endl;
}
// {/fact}
