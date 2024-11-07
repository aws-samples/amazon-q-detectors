// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-use-ecb-mode@v1.0 defects=0}
using System;
using System.Security.Cryptography;

namespace Cryptography.Compliant
{
    class InsecureCryptography
    {
        public void InsecureCryptographyCompliant()
        {
            using Aes aeskey = Aes.Create();
            // Compliant: `CBC` is a secure encryption mode.
            aeskey.Mode = CipherMode.CBC;
            using var encryptor = aeskey.CreateEncryptor();
            byte[] msg = new byte[32];
            var cipherText = encryptor.TransformFinalBlock(msg, 0, msg.Length);
            Console.WriteLine("Encryption using CBC mode successful.");
        }
        public static void Main()
        {
            var crypto = new InsecureCryptography();
            crypto.InsecureCryptographyCompliant();
        }
    }
}
// {/fact}
