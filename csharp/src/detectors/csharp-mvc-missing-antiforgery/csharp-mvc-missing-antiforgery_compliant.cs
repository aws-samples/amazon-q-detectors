// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-mvc-missing-antiforgery@v1.0 defects=0}

using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Threading.Tasks;

namespace CSRF.Compliant
{
    public class User
    {
        public string? Username { get; set; }
        public string? Email { get; set; }
    }

    [ApiController]
    [Route("api/[controller]")]
    public class CrossSiteRequestForgery : ControllerBase
    {
        [HttpPost("create")]
        // Compliant: Enforce anti-forgery token validation.
        [ValidateAntiForgeryToken]
        public IActionResult CrossSiteRequestForgeryCompliant([FromBody] User user)
        {
            CreateUser(user);
            return Ok(new { message = "User created successfully" });
        }

        private void CreateUser(User user)
        {
            if (user == null || string.IsNullOrEmpty(user.Username))
            {
                throw new ArgumentException("Invalid user data");
            }
            Console.WriteLine($"Creating user: {user.Username}");
        }
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);
            builder.Services.AddControllers();
            builder.Services.AddAntiforgery();
            var app = builder.Build();
            app.UseRouting();
            app.UseAntiforgery();
            app.MapControllers();

            app.Run();
        }
    }
}
// {/fact}