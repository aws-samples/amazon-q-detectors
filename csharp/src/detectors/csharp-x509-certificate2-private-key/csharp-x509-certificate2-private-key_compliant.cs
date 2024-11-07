// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-x509-certificate2-private-key@v1.0 defects=0}
using System;
using System.Security.Cryptography.X509Certificates;

namespace Cryptography.Compliant
{
    class ObsoleteCryptography
    {
        public void ObsoleteCryptographyCompliant()
        {
            X509Certificate2 certificate = new X509Certificate2("path/to/certificate.pfx", "yourPassword");
            
            // Compliant: `X509Certificate2.GetRSAPrivateKey()` is safe and recommended.
            using var privatekey = certificate.GetRSAPrivateKey();
            Console.WriteLine("Compliant: Successfully retrieved private key using a secure method.");
        }
        public static void Main()
        {
            var crypto = new ObsoleteCryptography();
            crypto.ObsoleteCryptographyCompliant();
        }
    }
}
 // {/fact}