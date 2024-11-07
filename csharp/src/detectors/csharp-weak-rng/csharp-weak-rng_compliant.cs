// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-weak-rng@v1.0 defects=0}
using System;
using System.Security.Cryptography;

namespace Cryptography.Compliant
{
    class WeakRandomNumberGeneration
    {
        public void WeakRandomNumberGenerationCompliant()
        {
            using var randomnumber = RandomNumberGenerator.Create();
            byte[] key = new byte[16];
            randomnumber.GetBytes(key);
            // Compliant: Secure random number generator (RNG) is used to create cryptographic key.
            using var aesGcm = new AesGcm(key, 16);
            Console.WriteLine("Compliant: Secure random number generated successfully.");
        }
        public static void Main()
        {
            var generator = new WeakRandomNumberGeneration();
            generator.WeakRandomNumberGenerationCompliant();
        }
    }
}
// {/fact}