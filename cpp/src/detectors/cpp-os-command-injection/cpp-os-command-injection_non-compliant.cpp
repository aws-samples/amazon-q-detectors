// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-os-command-injection@v1.0 defects=1}
#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

int noncompliant() {
  std::string filename;
  std::cout << "Enter a filename: ";
  std::cin >> filename;
  std::string command = "ls " + filename;
  // Noncompliant: Untrusted user input passed into `system` methods.
  system(command.c_str());
  return 0;
}
// {/fact}
