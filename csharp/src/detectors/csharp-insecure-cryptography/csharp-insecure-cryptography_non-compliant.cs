// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-insecure-cryptography@v1.0 defects=1}
using System.Security.Cryptography;
using System;

namespace Cryptography.NonCompliant
{
    class InsecureCryptography
    {
        public void UseInsecureHashAlgorithm()
        {
            // Noncompliant: `MD5` is considered insecure and should not be used.
            var hashProvider2 = (HashAlgorithm)CryptoConfig.CreateFromName("MD5");
            Console.WriteLine("Using MD5, which is insecure.");
        }
    }
}
// {/fact}
