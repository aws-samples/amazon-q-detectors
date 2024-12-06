// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-deserialization-formats@v1.0 defects=1}
using System;
using System.Text.Json;

namespace InsecureDeserialization.Compliant
{
    public class SecureJsonDeserialization
    {
        public static void Main(string[] args)
        {
            string jsonData = "{\"Name\":\"John Doe\",\"Age\":30}";
            DeserializeDataSafely(jsonData);
        }

        public static void DeserializeDataSafely(string jsonData)
        {
            // Compliant: Using `System.Text.Json` to safely deserialize JSON.
            var person = JsonSerializer.Deserialize<Person>(jsonData);
            Console.WriteLine($"Name: {person.Name}, Age: {person.Age}");
        }
    }

    public class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }
    }
}
// {/fact}