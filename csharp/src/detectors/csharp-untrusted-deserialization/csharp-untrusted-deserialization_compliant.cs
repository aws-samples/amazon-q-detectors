// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-untrusted-deserialization@v1.0 defects=0}
using System;
using System.IO;
using Newtonsoft.Json;

namespace SecureDeserialization
{
    public class ConformantDeserialization
    {
        public void SafeDeserialization(string json)
        {
            try
            {
                // Compliant: Using JsonConvert with type restrictions prevents arbitrary code execution during deserialization.
                var settings = new JsonSerializerSettings
                {
                    TypeNameHandling = TypeNameHandling.None
                };

                var result = JsonConvert.DeserializeObject<SafeObject>(json, settings);
                Console.WriteLine($"Deserialized object: {result}");
            }
            catch (Exception e)
            {
                Console.WriteLine($"An error occurred: {e.Message}");
            }
        }

        public class SafeObject
        {
            public string Name { get; set; }
            public int Age { get; set; }
        }

        public static void Main()
        {
            ConformantDeserialization example = new ConformantDeserialization();
            string jsonInput = "{\"Name\":\"John\",\"Age\":30}";
            example.SafeDeserialization(jsonInput);
        }
    }
}
//{/fact}