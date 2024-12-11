// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sslcertificatetrust-handshake-no-trust@v1.0 defects=0}
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;

public class ConformingSslCertificateTrust
{
    private X509Certificate2Collection certCollection;

    public ConformingSslCertificateTrust()
    {
        certCollection = new X509Certificate2Collection();
    }

    private void Conforming(string arg1)
    {
        // Compliant: Creates `SslCertificateTrust` without disabling certificate validation.
        var collection = SslCertificateTrust.CreateForX509Collection(certCollection);

    }

    public static void Main()
    {
        ConformingSslCertificateTrust example = new ConformingSslCertificateTrust();
        example.Conforming("example");
    }
}
//{/fact}