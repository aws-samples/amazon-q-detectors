// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-weak-cipher-algorithm@v1.0 defects=0}
using System;
using System.Security.Cryptography;

namespace SecureCryptoExample
{
    public class ConformantCipherAlgorithm
    {
        public void CreateAes()
        {
            // Compliant: Using `AES`, a strong and recommended encryption algorithm.
            var key = Aes.Create();
        }

        public static void Main()
        {
            ConformantCipherAlgorithm example = new ConformantCipherAlgorithm();
            example.CreateAes();
        }
    }
}
//{/fact}