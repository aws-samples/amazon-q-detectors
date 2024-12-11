// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-cryptography@v1.0 defects=0}
using System.Security.Cryptography;
using System;

namespace Cryptography.Compliant
{
    class SecureCryptography
    {
        public static void Main(string[] args)
        {
            // Compliant: `SHA512Managed` is a secure cryptographic algorithm.
            var hashProvider2 = (HashAlgorithm)CryptoConfig.CreateFromName("SHA512Managed");
            Console.WriteLine("Using SHA512Managed for secure hashing.");
        }
    }
}
// {/fact}
