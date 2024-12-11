// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-x509-subject-name-validation@v1.0 defects=1}
using System;
using System.IdentityModel.Tokens;

namespace System.IdentityModel.Samples
{
    public class NonConformantIssuerNameRegistry : IssuerNameRegistry
    {
        public override string GetIssuerName(SecurityToken securityToken)
        {
            X509SecurityToken x509Token = securityToken as X509SecurityToken;
            if (x509Token != null)
            {
                // Noncompliant: Only checks the subject name without proper certificate validation.
                if (String.Equals(x509Token.Certificate.SubjectName.Name, "CN=localhost"))
                {
                    return x509Token.Certificate.SubjectName.Name;
                }
            }
            return null;
        }
    }
}
//{/fact}