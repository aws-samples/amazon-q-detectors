// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-insecure-apis@v1.0 defects=0}
#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <fstream>
#include <iostream>

#define BUFFER_SIZE 256

void compliant() {
    char templateName[] = "fileXXXXXX";
    int fileDescriptor = mkstemp(templateName);
    FILE* file = fdopen(fileDescriptor, "w");
    // Compliant: Use `mkstemp` to avoid race conditions and security vulnerabilities.
    fprintf(file, "This is safe content.\n");
    fclose(file);
}
// {/fact}
