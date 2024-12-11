// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-ssrf-in-webrequest@v1.0 defects=0}
using System.Net.WebRequest;
using System.Uri;

namespace Ssrf
{
    public class ConformantWebRequest
    {
        public void SafeWebRequest(string host)
        {
            try
            {
                // Compliant: Using a constant URL instead of user-supplied input prevents SSRF attacks.
                WebRequest webRequest = WebRequest.Create("https://example.com");

                using (WebResponse response = webRequest.GetResponse())
                {
                    Console.WriteLine($"Content length: {response.ContentLength}");
                }
            }
            catch (Exception e)
            {
                Console.WriteLine($"An error occurred: {e.Message}");
            }
        }

        public static void Main()
        {
            ConformantWebRequest example = new ConformantWebRequest();
            example.SafeWebRequest("https://malicious.com");
        }
    }
}
//{/fact}