// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-open-directory-listing@v1.0 defects=0}
using Microsoft.AspNetCore.Builder;

namespace YourNamespace
{
    public class ConformantStaticFiles
    {
        public void conformant_static_files(IApplicationBuilder app)
        {
            app.UseAuthorization();
            // Compliant: `UseAuthorization` is called before `UseStaticFiles`, ensuring proper authorization checks.
            app.UseStaticFiles();
        }
    }
}
// {/fact}
