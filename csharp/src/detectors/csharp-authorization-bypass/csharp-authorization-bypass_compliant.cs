// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-authorization-bypass@v1.0 defects=0}
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authentication.JwtBearer;

namespace Authorization.Compliant
{
    // Compliant: Access only permitted for specific role.
    [Authorize(Roles = "LegalAdultGroup")]
    public class LegalAgeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        private new IActionResult View()
        {
            return new OkResult();
        }

        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);
            builder.Services.AddControllers();
            builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
                .AddJwtBearer();
            builder.Services.AddAuthorization();
            var app = builder.Build();
            app.UseAuthentication();
            app.UseAuthorization();
            app.MapControllers();

            app.Run();
        }
    }
}
 // {/fact}