// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-insecure-apis@v1.0 defects=1}
#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <fstream>
#include <iostream>

void nonompliant() {
    char templateName[] = "/tmp/fileXXXXXX";
    FILE* file = fopen(templateName, "w");
    // Noncompliant: Avoid using `mktemp` as it can lead to race conditions and security vulnerabilities.
    mktemp(templateName);
    fprintf(file, "This is unsafe content.\n");
    fclose(file);
}
// {/fact}
