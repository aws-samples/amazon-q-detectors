// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-assembly-path-injection@v1.0 defects=1}
using System;
using System.Reflection;
using Microsoft.AspNetCore.Http;

namespace CsharpAssemblyPathInjection.NonCompliant
{
    public class AssemblyPathInjectionHandler
    {
        public void ProcessRequest(HttpContext ctx)
        {
            string assemblyPath = ctx.Request.Query["assemblyPath"];
            // Noncompliant: Loads assembly based on unvalidated user input, allowing potential RCE.
            Assembly badAssembly = Assembly.LoadFile(assemblyPath);
            MethodInfo method = badAssembly.GetType("Config").GetMethod("GetCustomPath");
            object customPath = method.Invoke(null, null);
        }

        private Assembly LoadSafeAssembly(string path)
        {
            try
            {
                return Assembly.LoadFrom(path);
            }
            catch (Exception ex)
            {
                return null;
            }
        }
    }
}
// {/fact}
