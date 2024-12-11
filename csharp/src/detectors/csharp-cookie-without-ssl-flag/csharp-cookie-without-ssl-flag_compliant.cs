// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-cookie-without-ssl-flag@v1.0 defects=0}
using Microsoft.AspNetCore.Http;
using System;

namespace CookieWithoutSSLFlag.Compliant
{
    public class CookieExample
    {
        public void Compliant(HttpContext context, string key, string value)
        {
            var cookieOptions = new CookieOptions
            {
                // Compliant: `SSL` flag is set to `true`, enforcing secure transmission.
                Secure = true
            };
            context.Response.Cookies.Append(key, value, cookieOptions);
        }

        public static void Main()
        {
            Console.WriteLine("Compliant example setting Secure flag to true on a cookie.");
        }
    }
}
// {/fact}
