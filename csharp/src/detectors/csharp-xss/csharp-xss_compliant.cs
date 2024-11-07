// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xss@v1.0 defects=0}
using System;
using System.Net;
using Microsoft.AspNetCore.Mvc;

namespace Xss.Compliant
{
    public class CrossSiteScripting : Controller
    {
        [HttpPost]
        [ValidateAntiForgeryToken]
        public string Post(string untrusted)
        {
            // Compliant: Encode untrusted data before use.
            return "value " + WebUtility.HtmlEncode(untrusted);
        }
        public static void Main()
        {
            var compliantExample = new CrossSiteScripting();
            string result = compliantExample.Post("<script>alert('XSS')</script>");
            Console.WriteLine("Encoded output: " + result);
        }
    }
}
// {/fact}