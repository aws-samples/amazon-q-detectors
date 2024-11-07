// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-unrestricted-file-upload@v1.0 defects=1}
using System;
using System.IO;

namespace FileUpload.NonCompliant
{
    class UnrestrictedFileUpload
    {
        private string uploadedFile;
        private string fileContent;
        private string safeUploadFolder = @"C:\temp\secure";
        public void UnrestrictedFileUploadNoncompliant()
        {
            try {
                // Noncompliant: Allows unrestricted file upload without validating file type or content, potentially enabling malicious file execution.
                string completePathNewFile = safeUploadFolder + System.IO.Path.PathSeparator + uploadedFile;
                if (!File.Exists(completePathNewFile))
                {
                    using (StreamWriter sw = File.CreateText(completePathNewFile))
                    {
                        sw.WriteLine(fileContent);
                    }
                }
                Console.WriteLine("Non-Compliant Upload SUCCESS");
            } catch {
                Console.WriteLine("Non-Compliant Upload ERROR");
            }
        }
    }
}
// {/fact}