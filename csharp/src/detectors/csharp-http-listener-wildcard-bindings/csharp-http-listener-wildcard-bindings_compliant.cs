// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-http-listener-wildcard-bindings@v1.0 defects=0}
using System;
using System.Net;

namespace HttpListenerWildcardBindings.Compliant
{
    public class ModuleInjection
    {
        public void StartHttpListenerCompliant()
        {
            // Compliant: Uses specific IP address and port instead of wildcard bindings, reducing potential attack surface.
            HttpListener listener = new HttpListener();
            listener.Prefixes.Add("http://127.0.0.1:8080/");
            listener.Start();
            Console.WriteLine("Listening...");
            listener.Stop();
        }
        public static void Main(string[] args)
        {
            ModuleInjection module = new ModuleInjection();
            module.StartHttpListener();
            Console.WriteLine("HTTP Listener started and stopped successfully.");
        }
    }
}
// {/fact}