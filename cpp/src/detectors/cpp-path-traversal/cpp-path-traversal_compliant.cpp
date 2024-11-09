// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-path-traversal@v1.0 defects=0}
#include <iostream>
#include <string>
#include <juce_core/juce_core.h>

using namespace juce;

bool isValidFilePath(const String& filepath) {
    File file(filepath);
    return file.existsAsFile(); 
}


int compliant(int argc, char** argv)  {

    juce::File zipFile("example.zip");
    juce::File destinationDir("extracted_files");
 
    juce::ZipFile zip(zipFile);
 
    for (int i = 0; i < zip.getNumEntries(); ++i) {
        juce::ZipFile::ZipEntry entry(zip.getEntry(i));
        juce::File extractedFile(destinationDir.getChildFile(entry.filename));

        // Compliant: Presence of validation logic for the zipped file path. 
        if (isValidZipPath(entry.filename)) {
            extractedFile.create();
            std::unique_ptr<juce::FileOutputStream> outputStream(extractedFile.createOutputStream());
            outputStream->write(zip.decompressEntry(i), entry.uncompressedSize);
        } else {
            std::cout << "Error: Invalid path in ZIP archive - " << entry.filename << std::endl;
        }
    }
 
    return 0;
}
// {/fact}
