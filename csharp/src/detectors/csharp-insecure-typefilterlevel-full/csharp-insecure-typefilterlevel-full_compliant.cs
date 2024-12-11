// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-typefilterlevel-full@v1.0 defects=0}
using System;
using System.Runtime.Remoting.Channels;
using System.Runtime.Serialization.Formatters;
using Newtonsoft.Json;

namespace SecureDeserialization
{
    public class ConformantDeserialization
    {
        public void ProcessData(string json)
        {
            // Compliant: Using a safe deserialization method with type restrictions.
            var settings = new JsonSerializerSettings
            {
                TypeNameHandling = TypeNameHandling.None
            };

            var data = JsonConvert.DeserializeObject<SafeDataType>(json, settings);

            Console.WriteLine($"Processed data: {data}");
        }

        public class SafeDataType
        {
            public string Name { get; set; }
            public int Value { get; set; }
        }

        public static void Main()
        {
            ConformantDeserialization example = new ConformantDeserialization();
            example.ProcessData("{\"Name\":\"Test\",\"Value\":123}");
        }
    }
}
// {/fact}