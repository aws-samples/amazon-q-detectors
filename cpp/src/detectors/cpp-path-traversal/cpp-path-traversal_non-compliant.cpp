// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-path-traversal@v1.0 defects=1}
#include <iostream>
#include <string>
#include <juce_core/juce_core.h>

int noncompliant() {
     juce::File zipFile("example.zip");
     juce::File destinationDir("extracted_files");
 
     // Noncompliant: No path validation present for verifying the validity of the zipped file path. 
     juce::ZipFile::extractAllTo(zipFile, destinationDir);
 
     return 0;
}
// {/fact}
