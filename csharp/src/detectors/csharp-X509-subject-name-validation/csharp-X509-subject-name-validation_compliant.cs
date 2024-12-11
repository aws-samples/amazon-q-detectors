// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-x509-subject-name-validation@v1.0 defects=0}
using System;
using System.IdentityModel.Tokens;
using System.Security.Cryptography.X509Certificates;

namespace System.IdentityModel.Samples
{
    public class ConformantIssuerNameRegistry : IssuerNameRegistry
    {
        public override string GetIssuerName(SecurityToken securityToken)
        {
            X509SecurityToken x509Token = securityToken as X509SecurityToken;
            if (x509Token != null)
            {
                // Compliant: Validates the entire certificate chain and uses a whitelist of trusted thumbprints.
                if (ValidateCertificate(x509Token.Certificate))
                {
                    return x509Token.Certificate.Subject;
                }
            }
            return null;
        }

        private bool ValidateCertificate(X509Certificate2 certificate)
        {

            X509Chain chain = new X509Chain();
            chain.ChainPolicy.RevocationMode = X509RevocationMode.Online;
            chain.ChainPolicy.RevocationFlag = X509RevocationFlag.EntireChain;

            if (chain.Build(certificate))
            {
                return IsThumbprintTrusted(certificate.Thumbprint);
            }

            return false;
        }

        private bool IsThumbprintTrusted(string thumbprint)
        {
            string[] trustedThumbprints = { "ABCDEF1234567890", "1234567890ABCDEF" };
            return Array.Exists(trustedThumbprints, t => t.Equals(thumbprint, StringComparison.OrdinalIgnoreCase));
        }
    }
}
//{/fact}