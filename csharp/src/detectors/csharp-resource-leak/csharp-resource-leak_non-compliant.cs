// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-resource-leak@v1.0 defects=0}
using System;
using System.IO;

namespace ResourceLeakExample
{
    public class NonConformantResourceLeak
    {
        public void NonConformant()
        {
            string filePath = @"/etc/hosts";
            string line;
            try
            {
                // Noncompliant: `FileStream and` `StreamReader` are not properly disposed, potentially causing resource leaks.
                FileStream fileStream = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                StreamReader reader = new StreamReader(fileStream);
                while ((line = reader.ReadLine()) != null)
                {
                    Console.WriteLine(line);
                }
            }
            catch (IOException e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public static void Main()
        {
            NonConformantResourceLeak program = new NonConformantResourceLeak();
            program.NonConformant();
        }
    }
}
//{/fact}