// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-stack-trace-exposure@v1.0 defects=1}
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.Hosting;

namespace StackTrace.NonCompliant
{
    class StackTraceExposure
    {
        public void StackTraceExposureNoncompliant(IApplicationBuilder application, IHostEnvironment environment)
        {
            if (!environment.IsDevelopment())
            {
                // Noncompliant: Stacktrace information is displayed in a non-Development environment.
                application.UseDeveloperExceptionPage();
            }
            else
            {
                application.UseExceptionHandler("/Error");
            }
        }
    }
}
 // {/fact}
