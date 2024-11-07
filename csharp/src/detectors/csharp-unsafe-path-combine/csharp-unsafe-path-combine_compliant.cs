// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unsafe-path-combine@v1.0 defects=0}
using System;
using System.IO;

namespace Traversal.Compliant
{
    class PathTraversal
    {
        public static byte[] PathTraversalCompliant(string filename)
        {
            if (string.IsNullOrEmpty(filename)) 
            {   
                throw new ArgumentNullException("error"); 
            }
            filename = Path.GetFileName(filename);
            // Compliant: `Path.GetFileName` used for sanitization.
            string filepath = Path.Combine("/pathToMyImage/images/", filename); 
            return File.ReadAllBytes(filepath);
        }
        public static void Main()
        {
            try
            {
                byte[] data = PathTraversalCompliant("example.jpg");
                Console.WriteLine($"Read {data.Length} bytes successfully.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}
// {/fact}