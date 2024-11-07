// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-ssrf@v1.0 defects=1}
using System;
using System.Net.Http;

namespace SSRF.NonCompliant
{
    class ServerSideRequestForgery
    {
        public void ServerSideRequestForgeryNoncompliant(string hostname)
        {
            // Noncompliant: Takes a potentially unsafe external hostname.
            Uri uri = new Uri(hostname);

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
    }
}
// {/fact}
