// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-missing-hsts-header@v1.0 defects=1}
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

namespace YourNamespace
{
    public class Startup1
    {
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                // Noncompliant: HSTS is not implemented, potentially exposing the application to downgrade attacks.
                app.UseExceptionHandler("/Error");
            }
        }
    }
}
//{/fact}