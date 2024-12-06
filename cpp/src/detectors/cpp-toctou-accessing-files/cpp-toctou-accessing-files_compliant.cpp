// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-toctou-accessing-files@v1.0 defects=0}
#include <iostream>
#include <fstream>
#include <string>
#include <mutex>
#include <unistd.h> 

std::mutex fileMutex;

void compliant(const std::string& filename, const std::string& content) {
    fileMutex.lock();

    if (access(filename.c_str(), F_OK) != -1) {
        std::ofstream file(filename, std::ios::app);
        if (file.is_open()) {
            // Compliant: File is locked before using `access()` and `is_open()`.
            file << "This is some new content ...." << std::endl;
            file.close();
            std::cout << "Content successfully appended to " << filename << std::endl;
        } else {
            std::cerr << "Error opening file for writing." << std::endl;
        }
    } else {
        std::cerr << "File not found." << std::endl;
    }

    fileMutex.unlock();
}
// {/fact}
