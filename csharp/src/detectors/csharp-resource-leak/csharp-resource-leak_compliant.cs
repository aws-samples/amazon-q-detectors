// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-resource-leak@v1.0 defects=1}
using System;
using System.IO;

namespace ResourceLeakExample
{
    public class ConformantResourceLeak
    {
        public void Conformant()
        {
            string filePath = @"/etc/hosts";
            try
            {
                // Compliant: Using statement ensures proper disposal of `FileStream` and `StreamReader`.
                using (FileStream fileStream = new FileStream(filePath, FileMode.Open, FileAccess.Read))
                using (StreamReader reader = new StreamReader(fileStream))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        Console.WriteLine(line);
                    }
                }
            }
            catch (IOException e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public static void Main()
        {
            ConformantResourceLeak program = new ConformantResourceLeak();
            program.Conformant();
        }
    }
}
//{/fact}