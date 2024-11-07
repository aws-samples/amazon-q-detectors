// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-newtonsoft-deserialization@v1.0 defects=0}
using Newtonsoft.Json;
using System;

namespace InsecureDeserialization
{
    class UntrustedDeserialization
    {
        public void UntrustedDeserializationCompliant(string jsonpath)
        {
            JsonConvert.DeserializeObject<object>(jsonpath, new JsonSerializerSettings
            {
                // Compliant: `TypeNameHandling.None` is safe.
                TypeNameHandling = TypeNameHandling.None
            });
        }
        static void Main()
        {
            Console.WriteLine("compiled successfully.");
        }
    }
}
 // {/fact}
