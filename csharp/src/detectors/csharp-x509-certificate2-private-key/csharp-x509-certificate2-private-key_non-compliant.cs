// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-x509-certificate2-private-key@v1.0 defects=1}
using System;
using System.Security.Cryptography.X509Certificates;

namespace Cryptography.NonCompliant
{
    class ObsoleteCryptography
    {
        public void ObsoleteCryptographyNoncompliant()
        {
            X509Certificate2 certificate = new X509Certificate2("path/to/certificate.pfx", "yourPassword");
            // Noncompliant: `X509Certificate2.PrivateKey` is obsolete and insecure.
            var privatekey = certificate.PrivateKey;
            Console.WriteLine("Non-Compliant: Retrieved private key using an obsolete and insecure method.");
        }
       
    }
}
 // {/fact}