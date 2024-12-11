// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-typefilterlevel-full@v1.0 defects=1}
using System;
using System.Runtime.Remoting.Channels;
using System.Runtime.Serialization.Formatters;

namespace InsecureDeserialization
{
    public class NonConformantTypeFilterLevel
    {
        public void SetTFL(string json)
        {
            var formatterProps = new System.Collections.Hashtable();
            BinaryServerFormatterSinkProvider serverProvider = new BinaryServerFormatterSinkProvider(formatterProps, null);

            // Noncompliant: Setting `TypeFilterLevel` to `Full` allows deserialization of all types, which is a security risk.
            serverProvider.TypeFilterLevel = TypeFilterLevel.Full;

            Console.WriteLine($"TypeFilterLevel set to: {serverProvider.TypeFilterLevel}");
        }

        public static void Main()
        {
            NonConformantTypeFilterLevel example = new NonConformantTypeFilterLevel();
            example.SetTFL("{}");
        }
    }
}
// {/fact}