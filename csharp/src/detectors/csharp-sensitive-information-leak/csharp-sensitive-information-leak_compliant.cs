// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-sensitive-information-leak@v1.0 defects=0}
using System;
using System.Net.Http;
using System.Threading.Tasks;

namespace SensitiveInformation.Compliant
{
    public class SensitiveInformationLeak
    {
        public async Task SensitiveInformationLeakCompliant()
        {
            string url = "https://api.example.com";
            string apiKey = "YOUR_API_KEY";

            using (HttpClient client = new HttpClient())
            {
                // Compliant: Use HTTPS connection to send sensitive data securely.
                client.DefaultRequestHeaders.Add("X-API-Key", apiKey);
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                string responseContent = await response.Content.ReadAsStringAsync();
                Console.WriteLine($"Response: {responseContent}");
            }
        }

        public static async Task Main(string[] args)
        {
            try
            {
                var compliant = new SensitiveInformationLeak();
                await compliant.SensitiveInformationLeakCompliant();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}
 // {/fact}