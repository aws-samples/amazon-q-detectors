// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-use-weak-rsa-encryption-padding@v1.0 defects=0}
using System;
using System.Security.Cryptography;

namespace SecureRSAExample
{
    public class ConformantRSAEncryption
    {
        static public byte[] EncryptWithRSAAndPadding(byte[] plaintext, RSAParameters key)
        {
            try
            {
                using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
                {
                    rsa.ImportParameters(key);
                    // Compliant: Using `RSA` encryption with padding enhances security against padding oracle attacks.
                    return rsa.Encrypt(plaintext, true);
                }
            }
            catch (CryptographicException e)
            {
                Console.WriteLine($"Encryption failed: {e.Message}");
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
                    byte[] ciphertext = EncryptWithRSAAndPadding(plaintext, rsa.ExportParameters(false));

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