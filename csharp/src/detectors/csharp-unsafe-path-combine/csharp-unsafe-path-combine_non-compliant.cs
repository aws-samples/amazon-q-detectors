// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unsafe-path-combine@v1.0 defects=1}
using System;
using System.IO;

namespace Traversal.NonCompliant
{
    class PathTraversal
    {
        public static byte[] PathTraversalNoncompliant(string filename)
        {
            if (string.IsNullOrEmpty(filename)) 
            {   
                throw new ArgumentNullException("error"); 
            }
            string filepath = Path.Combine("/pathToMyImage/images/", filename); 
            // Noncompliant: Reading data from a file without sanitization.
            return File.ReadAllBytes(filepath);
        }
    }
}
// {/fact}