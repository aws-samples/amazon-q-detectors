// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-cookie-without-http-only-flag@v1.0 defects=1}
using Microsoft.AspNetCore.Http;
using Newtonsoft.Json;
using System;

namespace CookieWithoutHttpOnlyFlag.NonCompliant
{
    public class CookieExamples
    {
        private readonly object _items = new object();

        public void NonCompliant(HttpContext context)
        {
            var cartJson = JsonConvert.SerializeObject(_items);

            context.Response.Cookies.Append("cart", cartJson, new CookieOptions
            {
                Expires = DateTime.Now.AddDays(7),
                // Noncompliant: `HttpOnly` flag is set to `false`, allowing client-side access.
                HttpOnly = false
            });
        }
    }
}
// {/fact}
