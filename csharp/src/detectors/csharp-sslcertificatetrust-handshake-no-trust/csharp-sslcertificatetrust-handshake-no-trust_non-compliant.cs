// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sslcertificatetrust-handshake-no-trust@v1.0 defects=1}
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;

public class NonConformingSslCertificateTrust
{
    private X509Certificate2Collection certCollection;

    public NonConformingSslCertificateTrust()
    {
        certCollection = new X509Certificate2Collection();
    }

    private void NonConforming(string arg1)
    {
        // Noncompliant: Creates `SslCertificateTrust` with certificate validation disabled, potentially allowing untrusted certificates.
        var collection = SslCertificateTrust.CreateForX509Collection(certCollection, true);

    }

    public static void Main()
    {
        NonConformingSslCertificateTrust example = new NonConformingSslCertificateTrust();
        example.NonConforming("example");
    }
}
//{/fact}