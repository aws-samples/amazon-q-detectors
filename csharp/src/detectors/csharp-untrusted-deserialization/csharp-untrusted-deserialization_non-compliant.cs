// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-untrusted-deserialization@v1.0 defects=1}
using System;
using System.IO;
using MBrace.FsPickler.Json;

namespace InsecureDeserialization
{
    public class NonConformantDeserialization
    {
        public void UnsafeDeserialization(string json)
        {
            try
            {
                // Noncompliant: Using `FsPickler` to deserialize untrusted data can lead to arbitrary code execution.
                var fsPickler = FsPickler.CreateJsonSerializer();
                MemoryStream memoryStream = new MemoryStream(Convert.FromBase64String(json));
                var result = fsPickler.Deserialize<object>(memoryStream);
                Console.WriteLine($"Deserialized object: {result}");
            }
            catch (Exception e)
            {
                Console.WriteLine($"An error occurred: {e.Message}");
            }
        }

        public static void Main()
        {
            NonConformantDeserialization example = new NonConformantDeserialization();
            string jsonInput = Convert.ToBase64String(System.Text.Encoding.UTF8.GetBytes("{\"$type\":\"System.IO.FileInfo, mscorlib\",\"FileName\":\"sensitive.txt\"}"));
            example.UnsafeDeserialization(jsonInput);
        }
    }
}
//{/fact}