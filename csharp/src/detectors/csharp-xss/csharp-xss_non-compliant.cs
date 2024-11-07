// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-xss@v1.0 defects=1}
using System;
using System.Net;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc;

namespace Xss.NonCompliant
{
    public class CrossSiteScripting : Controller
    {
        [HttpGet]
        public string Get(string untrusted)
        {
            // Noncompliant: Directly outputting untrusted user input to the response without proper encoding can lead to Cross-Site Scripting (XSS) vulnerabilities.
            return "value " + untrusted;
        }
    }
}
// {/fact}