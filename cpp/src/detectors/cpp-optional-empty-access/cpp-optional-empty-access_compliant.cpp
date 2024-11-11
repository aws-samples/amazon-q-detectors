// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-optional-empty-access@v1.0 defects=0}
#include <stdio.h>
#include <optional> 
#include <iostream>

void compliant() {
    std::optional<int> opt;
    // Compliant: Checking if optional has value before accessing.
    if (opt.has_value())
    {
        int value = *opt;
        std::cout << "Value: " << value << std::endl;
    }
    else
    {
        std::cout << "Optional does not have value." << std::endl;
    }
    
}
// {/fact}
