// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-command-injection@v1.0 defects=0}
using System;
using System.Diagnostics;

namespace CSharpInjection.Compliant
{
    public class OsCommandInjection
    {
        public void OsCommandInjectionCompliant(String path)
        {
            // Compliant: `ProcessStartInfo` is used to safely configure process execution, mitigating command injection risks.
            try
            {
                using var process = new Process();
                process.StartInfo = new ProcessStartInfo
                {
                    FileName = "path",
                    UseShellExecute = false,
                    RedirectStandardOutput = true,
                    CreateNoWindow = true
                };
                process.Start();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error executing command: {ex.Message}");
            }
        }
        public static void Main(string[] args)
        {
            OsCommandInjection injection = new OsCommandInjection();
            injection.OsCommandInjectionCompliant("test.exe");  
            Console.WriteLine("Compliant execution completed.");
        }
    }
}
// {/fact}