// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-command-injection@v1.0 defects=0}
#include <cstring>
#include <cstdlib>
#include <iostream>
#include <regex>

#define CMD_MAX 256

bool isValid(const char *input) {
    std::regex validpattern("^[a-za-z0-9_/\\.]+$");
    return std::regex_match(input, validpattern);
}

int compliant(int argc, char **argv) {
    if (argc < 2) {
        std::cerr << "error: missing argument" << std::endl;
        return -1;
    }

    if (isValid(argv[1])) {
        char cmd[CMD_MAX] = "/usr/bin/cat ";

        strcat(cmd, argv[1]);

        // Compliant: Input validation has been added before executing a command.
        system(cmd);

        return 0;
    }

    std::cerr << "error: invalid input" << std::endl;
    return -1;
}
// {/fact}
