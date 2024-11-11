// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-optional-empty-access@v1.0 defects=1}
#include <optional> 
#include <iostream>

void noncompliant() {
    std::optional<int> opt; 
    // Noncompliant: Accessing without checking if opt has value.
    int value = *opt;
    std::cout << "Value: " << value << std::endl;
}
// {/fact}
