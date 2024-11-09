// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-memory-address-exposure@v1.0 defects=0}
#include <iostream>

void compliant4()
{
    int var = 10;
    // Compliant: Printing the value stored at the memory address.
    std::cout << "Value of var: " << var << std::endl;
}
// {/fact}
