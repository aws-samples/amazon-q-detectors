// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unrestricted-file-upload@v1.0 defects=0}
using System;
using System.IO;
using FileUpload.NonCompliant;

namespace FileUpload.Compliant
{
    class UnrestrictedFileUpload
    {
        private string uploadedFile = "example.txt"; 
        private string fileContent = "This is a test file content.";
        private string safeUploadFolder = @"C:\temp\secure";
        public void UnrestrictedFileUploadCompliant()
        {
            try
            {
                // Compliant: Restricts upload path, uses `Path.GetFileName` to sanitize filename, and saves to a predefined secure location.
                string fileNameSanitized = Path.GetFileName(uploadedFile);
                string completePathNewFile = Path.Combine(safeUploadFolder, fileNameSanitized);

                if (!File.Exists(completePathNewFile))
                {
                    using (StreamWriter sw = File.CreateText(completePathNewFile))
                    {
                        sw.WriteLine(fileContent);
                    }
                }
                Console.WriteLine("Compliant Upload SUCCESS");
            }
            catch (Exception e)
            {
                Console.WriteLine("Compliant Upload ERROR: " + e.Message);
            }
        }       
        static void Main()
        {
            Console.WriteLine("Running Compliant File Upload Test:");
            var compliantUpload = new UnrestrictedFileUpload();
            compliantUpload.UnrestrictedFileUploadCompliant();
        }
    }
}
 // {/fact}