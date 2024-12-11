// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-open-directory-listing@v1.0 defects=1}
using Microsoft.AspNetCore.Builder;

namespace YourNamespace
{
    public class NonConformantStaticFiles
    {
        public void non_conformant_static_files(IApplicationBuilder app)
        {
            app.UseStaticFiles();
            // Noncompliant:  No authorization checks are performed on the static files as `UseAuthorization` is called later.
            app.UseAuthorization();
        }
    }
}
// {/fact}
