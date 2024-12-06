// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-avoid-persistent-cookies@v1.0 defects=0}
using System;
using System.Web;

namespace AvoidPersistentCookies.Compliant
{
    public class HttpCookie
    {
        public HttpCookie(string name) { }
        public string Value { set { } }
        public DateTime Expires { set { } }
        public string Domain { get; internal set; }
        public string Path { get; internal set; }
    }

    class Program
    {
        static void Main()
        {
            AddCookie();
            Console.WriteLine("Compliant cookie added.");
        }

        public static void AddCookie()
        {
            HttpCookie aCookie = new HttpCookie("lastVisit");
            aCookie.Value = DateTime.Now.ToString();
            // Compliant: Cookie expires in the past, making it non-persistent.
            aCookie.Expires = DateTime.Now.AddMinutes(-10.9);
        }
    }
}

// {/fact}
