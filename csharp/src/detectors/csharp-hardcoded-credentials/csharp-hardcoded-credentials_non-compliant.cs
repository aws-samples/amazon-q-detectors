// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-hardcoded-credentials@v1.0 defects=1}
using System;
using System.Net;

namespace Credentials.NonCompliant
{
    class HardcodedCredentials
    {
        public void HardcodedCredentialsNoncompliant()
        {
            string data;
            // Noncompliant: Password is hardcoded, which poses a security risk.
            data = "7e5tc4s3";

            if (data != null)
            {
                NetworkCredential credentials = new NetworkCredential("user", data, "domain");
                Console.WriteLine(credentials.ToString());
            }
        }
    }
}
// {/fact}
