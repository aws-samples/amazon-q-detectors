// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-use-ecb-mode@v1.0 defects=1}
using System;
using System.Security.Cryptography;

namespace Cryptography.NonCompliant
{
    class InsecureCryptography
    {
        public void InsecureCryptographyNoncompliant()
        {
            using Aes aeskey = Aes.Create();
            // Noncompliant: `ECB` is an insecure encryption mode.
            aeskey.Mode = CipherMode.ECB;
            using var encryptor = aeskey.CreateEncryptor();
            byte[] msg = new byte[32];
            var cipherText = encryptor.TransformFinalBlock(msg, 0, msg.Length);
            Console.WriteLine("Encryption using ECB mode completed.");
        }
    }
}
// {/fact}