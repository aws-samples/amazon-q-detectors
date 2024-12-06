// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-toctou-accessing-files@v1.0 defects=1}
#include <iostream>
#include <fstream>
#include <string>

void noncompliant(const std::string& filename) {
    if (access(filename.c_str(), F_OK) != -1) {
        std::ofstream file(filename, std::ios::app);
        if (file.is_open()) {
            // Noncompliant: When doing file operations like access() and is_open(), lock the file to prevent TOCTOU issues. 
            file << "This some new content ...." << std::endl;
            file.close();
            std::cout << "Content successfully appended to " << filename << std::endl;
        } else {
            std::cerr << "Error opening file for writing." << std::endl;
        }
    } else {
        std::cerr << "File not found." << std::endl;
    }
}
// {/fact}
