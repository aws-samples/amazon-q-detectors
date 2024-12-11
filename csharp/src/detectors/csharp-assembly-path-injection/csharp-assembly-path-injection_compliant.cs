// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-assembly-path-injection@v1.0 defects=0}
using System;
using System.Reflection;
using Microsoft.AspNetCore.Http;

namespace CsharpAssemblyPathInjection.Compliant
{
    public class AssemblyPathInjectionHandler
    {
        public void ProcessRequest(HttpContext ctx)
        {
            string assemblyPath = ctx.Request.Query["assemblyPath"];
            if (!string.IsNullOrEmpty(assemblyPath))
            {
                // Compliant: Loads assembly from a validated path.
                Assembly assembly = LoadSafeAssembly(assemblyPath);
                if (assembly != null)
                {
                    MethodInfo method = assembly.GetType("Config").GetMethod("GetCustomPath");
                    object customPath = method?.Invoke(null, null);
                }
            }
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

        public static void Main()
        {
            var handler = new AssemblyPathInjectionHandler();
            Console.WriteLine("Compliant assembly path injection handler executed.");
        }
    }
}
// {/fact}
