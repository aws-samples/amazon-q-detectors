// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-weak-rng@v1.0 defects=1}
using System;
using System.Security.Cryptography;

namespace Cryptography.NonCompliant
{
    class WeakRandomNumberGeneration
    {
        public void WeakRandomNumberGenerationNoncompliant()
        {
            var randomnumber = new Random();
            byte[] key = new byte[16];
            randomnumber.NextBytes(key);
            // Noncompliant: An insecure random number generator (RNG) is used to create cryptographic key.
            using var aesGcm = new AesGcm(key, 16);
            Console.WriteLine("Non-Compliant: Insecure random number generated.");
        }
    }
}
 // {/fact}