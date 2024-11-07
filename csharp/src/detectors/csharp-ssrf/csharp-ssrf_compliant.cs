// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-ssrf@v1.0 defects=0}
using System;
using System.Net.Http;
using SSRF.NonCompliant;

namespace SSRF.Compliant
{
    class ServerSideRequestForgery
    {
        public void ServerSideRequestForgeryCompliant(string hostname)
        {
            // Compliant: Uses a hardcoded safe URL.
            Uri uri = new Uri("https://example.com"); 

            HttpClient client = new HttpClient();

            try
            {
                HttpResponseMessage res = client.GetAsync(uri).Result;
                System.Diagnostics.Debug.WriteLine(res.StatusCode);
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
        }
        
        static void Main()
        {
            Console.WriteLine("compiled successfully.");
        }
    }
}
// {/fact}