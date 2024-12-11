// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-use-weak-rsa-encryption-padding@v1.0 defects=1}
using System;
using System.Security.Cryptography;

namespace InsecureRSAExample
{
    public class NonConformantRSAEncryption
    {
        static public byte[] EncryptWithRSAAndNoPadding(byte[] plaintext, RSAParameters key)
            {
                try
                {
                    RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
                    rsa.ImportParameters(key);
                    // Noncompliant: Using `RSA` encryption without padding is vulnerable to padding oracle attacks.
                    return rsa.Encrypt(plaintext, false);
                }
                catch (CryptographicException e)
                {
                    Console.WriteLine(e.Message);
                    return null;
                }
            }

        public static void Main()
        {
            try
            {
                using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
                {
                    byte[] plaintext = System.Text.Encoding.UTF8.GetBytes("Secret message");
                    byte[] ciphertext = EncryptWithRSAAndNoPadding(plaintext, rsa.ExportParameters(false));

                    if (ciphertext != null)
                    {
                        Console.WriteLine($"Encrypted data: {Convert.ToBase64String(ciphertext)}");
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine($"An error occurred: {e.Message}");
            }
        }
    }
}
//{/fact}