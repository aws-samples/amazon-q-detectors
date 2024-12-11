// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-ssrf-in-webrequest@v1.0 defects=1}
using System.Net.WebRequest;
using System.Uri;

namespace Ssrf
{
    public class NonConformantWebRequest
    {
        public void UnsafeWebRequest(string host)
        {
            try
            {
                // Noncompliant: Using user-supplied input directly in `WebRequest.Create` is vulnerable to SSRF attacks.
                WebRequest webRequest = WebRequest.Create(host);
            }
            catch (Exception e)
            {
                Console.WriteLine($"An error occurred: {e.Message}");
            }
        }

        public static void Main()
        {
            NonConformantWebRequest example = new NonConformantWebRequest();
            example.UnsafeWebRequest("https://malicious.com");
        }
    }
}
//{/fact}