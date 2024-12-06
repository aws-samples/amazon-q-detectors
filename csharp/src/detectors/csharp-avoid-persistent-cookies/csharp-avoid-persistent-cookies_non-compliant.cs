// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-avoid-persistent-cookies@v1.0 defects=1}
using System;
using System.Web;

namespace AvoidPersistentCookies.NonCompliant
{
    public class HttpCookie
    {
        public HttpCookie(string name) { }
        public string Value { set { } }
        public DateTime Expires { set { } }
        public string Domain { get; internal set; }
        public string Path { get; internal set; }
    }

    class Main
    {
        public static void AddCookie()
        {
            HttpCookie aCookie = new HttpCookie("lastVisit");
            aCookie.Value = DateTime.Now.ToString();
            // Noncompliant: Cookie expires in the future, making it persistent.
            aCookie.Expires = DateTime.Now.AddMinutes(10);
        }
    }
}
// {/fact}
