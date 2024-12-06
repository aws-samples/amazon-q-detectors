// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0
// {fact rule=csharp-insecure-deserialization-formats@v1.0 defects=1}
using System;
using System.IO;
using System.Text;
using System.Runtime.Serialization.Formatters.Binary;

namespace InsecureDeserialization.NonCompliant
{
    public class InsecureFormatterDeserialization
    {
        public void BinaryFormatterDeserialization(string json)
        {
            try
            {
                // Noncompliant: Using `BinaryFormatter`, which is obsolete and insecure.
                BinaryFormatter binaryFormatter = new BinaryFormatter();
                MemoryStream memoryStream = new MemoryStream(Encoding.UTF8.GetBytes(json));
                binaryFormatter.Deserialize(memoryStream);
                memoryStream.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
// {/fact}