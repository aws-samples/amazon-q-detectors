// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-cookie-without-http-only-flag@v1.0 defects=0}
using Microsoft.AspNetCore.Http;
using Newtonsoft.Json;
using System;

namespace CookieWithoutHttpOnlyFlag.Compliant
{
    public class CookieExamples
    {
        private readonly object _items = new object();

        public void Compliant(HttpContext context)
        {
            var cartJson = JsonConvert.SerializeObject(_items);

            context.Response.Cookies.Append("cart", cartJson, new CookieOptions
            {
                Expires = DateTime.Now.AddDays(7),
                // Compliant: `HttpOnly` flag is set to `true`.
                HttpOnly = true
            });
        }

        public static void Main()
        {
            var context = new DefaultHttpContext();
            var example = new CookieExamples();
            example.Compliant(context);
            Console.WriteLine("Compliant cookie added with HttpOnly flag set to true.");
        }
    }
}
// {/fact}
