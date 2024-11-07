// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sensitive-information-leak@v1.0 defects=1}
using System;
using System.Net.Http;
using System.Net.Security;
using System.Security.Cryptography.Xml;
using System.Threading.Tasks;

namespace SensitiveInformation.NonCompliant
{
    public class SensitiveInformationLeak
    {
        public async Task SensitiveInformationLeakNoncompliant()
        {
            string url = "http://api.example.com";
            string apiKey = "YOUR_API_KEY";

            using (HttpClient client = new HttpClient())
            {
                // Noncompliant: Send sensitive data over HTTP connection.
                HttpResponseMessage response = await client.GetAsync(url + "?api_key=" + apiKey);
                string responseContent = await response.Content.ReadAsStringAsync();
                Console.WriteLine($"Response: {responseContent}");
            }
        }
    }
}
// {/fact}