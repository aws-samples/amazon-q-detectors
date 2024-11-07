// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-stack-trace-exposure@v1.0 defects=0}
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.DependencyInjection;

namespace StackTrace.Compliant
{
    class StackTraceExposure
    {
        public void StackTraceExposureCompliant(IApplicationBuilder application, IHostEnvironment environment)
        {
            if (environment.IsDevelopment())
            {
                // Compliant: Stacktrace information is displayed only in a Development environment.
                application.UseDeveloperExceptionPage();
            }
            else
            {
                application.UseExceptionHandler("/Error");
            }
        }
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);
            var app = builder.Build();

            var compliantExample = new StackTraceExposure();
            compliantExample.StackTraceExposureCompliant(app, builder.Environment);
            
            app.Run();
        }
    }
}
 // {/fact}