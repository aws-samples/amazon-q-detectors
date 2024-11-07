// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-http-listener-wildcard-bindings@v1.0 defects=1}
using System;
using System.Net;

namespace HttpListenerWildcardBindings.NonCompliant
{
    public class ModuleInjection
    {
        public void StartHttpListenerNoncompliant()
        {
            // Noncompliant: Uses wildcard binding, potentially exposing the listener to unintended network interfaces.
            HttpListener listener = new HttpListener();
            listener.Prefixes.Add("http://*:8443/");
            if (HttpListener.IsSupported)
            {
                listener.Start();
                Console.WriteLine("Listening...");
                listener.Stop();
            }
        }
    }
}
// {/fact}