// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-do-not-disable-html-auto-escape@v1.0 defects=0}
#include <iostream>
#include <string>

std::string replace_all(std::string str, const std::string& from, const std::string& to) {
    size_t start_pos = 0;
    while ((start_pos = str.find(from, start_pos)) != std::string::npos) {
        str.replace(start_pos, from.length(), to);
        start_pos += to.length();
    }
    return str;
}

std::string escape_html(const std::string& input) {
    std::string escaped = input;
    escaped = replace_all(escaped, "&", "&amp;");
    escaped = replace_all(escaped, "<", "&lt;");
    escaped = replace_all(escaped, ">", "&gt;");
    escaped = replace_all(escaped, "\"", "&quot;");
    escaped = replace_all(escaped, "'", "&apos;");
    return escaped;
}

int compliant(int argc, char **argv){
    std::string userInput = argv[1];
    
    std::string safeOutput = escape_html(userInput);

    // Compliant: User input is properly escaped before rendering.
    std::cout << "<div>" << safeOutput << "</div>" << std::endl;

    return 0;
}

int main(int argc, char **argv) {
    return compliant(argc, argv);
}
// {/fact}
