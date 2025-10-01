// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-path-traversal@v1.0 defects=1}
using System;
using System.IO;

namespace FileOperations {
    public class UnsafeFileAccess
    {
        public static byte[] GetFileBad(string filename)
        {
            if (string.IsNullOrEmpty(filename))
            {
                throw new ArgumentNullException("filename", "Filename cannot be null or empty");
            }
            string filepath = Path.Combine(@"\\FILESHARE\images", filename);
            // Noncompliant: Directly using user input in file path without sanitization, vulnerable to path traversal.
            return File.ReadAllBytes(filepath);
        }
    }
}
// {/fact}