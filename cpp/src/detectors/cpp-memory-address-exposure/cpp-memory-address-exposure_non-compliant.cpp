// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-memory-address-exposure@v1.0 defects=1}
#include <iostream>

void noncompliant()
{
    int var;
    // Noncompliant: Printing the memory address directly.
    std::cout << "Memory address of var: " << &var << std::endl;
}
// {/fact}
