// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-command-injection@v1.0 defects=1}
using System;
using System.Diagnostics;

namespace CSharpInjection.NonCompliant
{
    public class OsCommandInjection
    {
        public void OsCommandInjectionNoncompliant(String path)
        {
            // Noncompliant: User input is directly passed to `Process.Start()` without validation, risking command injection.
            try
            {
                Process.Start(path); 
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error executing command: {ex.Message}");
            }
        }
    }
}
// {/fact}