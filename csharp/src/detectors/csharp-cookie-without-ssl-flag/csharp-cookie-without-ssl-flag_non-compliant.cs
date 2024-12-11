// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-cookie-without-ssl-flag@v1.0 defects=1}
using Microsoft.AspNetCore.Http;
using System;

namespace CookieWithoutSSLFlag.NonCompliant
{
    public class CookieExample
    {
        public void NonCompliant1(HttpContext context, string key, string value)
        {
            var cookieOptions = new CookieOptions
            {
                // Noncompliant: `SSL` flag is set to `false`, allowing insecure transmission.
                Secure = false
            };
            context.Response.Cookies.Append(key, value, cookieOptions);
        }
    }
}
// {/fact}
