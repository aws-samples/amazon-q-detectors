// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-path-traversal@v1.0 defects=0}
using System;
using System.IO;

namespace FileOperations
{
    public class SafeFileAccess
    {
        public static byte[] GetFileSafe(string filename)
        {
            if (string.IsNullOrEmpty(filename))
            {
                throw new ArgumentNullException("filename", "Filename cannot be null or empty");
            }
            filename = Path.GetFileName(filename);
           // Compliant: Using `Path.GetFileName` to sanitize the input and prevent path traversal.
            string filepath = Path.Combine(@"\\FILESHARE\images", filename);
            return File.ReadAllBytes(filepath);
        }
    }
}
// {/fact}