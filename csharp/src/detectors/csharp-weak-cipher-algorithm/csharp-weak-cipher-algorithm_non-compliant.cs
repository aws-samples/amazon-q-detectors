// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-weak-cipher-algorithm@v1.0 defects=1}
using System;
using System.Security.Cryptography;

namespace InsecureCryptoExample
{
    public class NonConformantCipherAlgorithm
    {
        public void DES()
            {
                // Noncompliant: `DES` is considered unsafe due to its short key length, making it vulnerable to brute-force attacks.
                DES provider = System.Security.Cryptography.DES.Create();

            }
        public static void Main()
        {
            NonConformantCipherAlgorithm example = new NonConformantCipherAlgorithm();
            example.CreateDES();
        }
    }
}
//{/fact}