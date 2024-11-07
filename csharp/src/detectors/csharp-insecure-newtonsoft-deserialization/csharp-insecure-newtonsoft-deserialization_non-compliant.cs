// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-newtonsoft-deserialization@v1.0 defects=1}
using Newtonsoft.Json;
using System;

namespace InsecureDeserialization.NonCompliant
{
    class UntrustedDeserialization
    {
        public void UntrustedDeserializationNoncompliant(string jsonpath)
        {
            JsonConvert.DeserializeObject<object>(jsonpath, new JsonSerializerSettings
            {
                // Noncompliant: `TypeNameHandling.All` is not safe.
                TypeNameHandling = TypeNameHandling.All
            });
        }
    }
}
 // {/fact}