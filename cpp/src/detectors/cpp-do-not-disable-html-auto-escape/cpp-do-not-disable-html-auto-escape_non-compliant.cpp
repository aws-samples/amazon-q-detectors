// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-do-not-disable-html-auto-escape@v1.0 defects=1}
#include <iostream>

int noncompliant(int argc, char **argv){
    std::string userInput = argv[1];

    // Noncompliant: HTML output is not properly escaped.
    std::cout << "<div>" << userInput << "</div>" << std::endl;

    return 0;
}
// {/fact}
