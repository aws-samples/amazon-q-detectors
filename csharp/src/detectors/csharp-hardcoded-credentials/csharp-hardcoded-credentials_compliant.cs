// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-hardcoded-credentials@v1.0 defects=0}
using System;
using System.Net;

namespace Credentials.Compliant
{
    class HardcodedCredentials
    {
        public static void Main(string[] args)
        {
            HardcodedCredentials compliantExample = new HardcodedCredentials();
            compliantExample.HardcodedCredentialsCompliant();
        }

        public void HardcodedCredentialsCompliant()
        {
            // Compliant: Password is fetched from the environment variable and not hardcoded.
            string data = Environment.GetEnvironmentVariable("APP_PASSWORD");

            if (string.IsNullOrEmpty(data))
            {
                Console.WriteLine("Error: Password environment variable is not set.");
                return;
            }

            NetworkCredential credentials = new NetworkCredential("user", data, "domain");
            Console.WriteLine($"Credentials created for user: {credentials.UserName}");
        }
    }
}
// {/fact}
