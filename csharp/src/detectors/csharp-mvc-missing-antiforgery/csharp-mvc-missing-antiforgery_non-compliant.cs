// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-mvc-missing-antiforgery@v1.0 defects=1}
using Microsoft.AspNetCore.Mvc;
using System;

namespace CSRF.NonCompliant
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
        [HttpPost]
        // Noncompliant: Does not enforce anti-forgery token validation.
        public ActionResult CrossSiteRequestForgeryNoncompliant([FromBody] User user)
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
    }
}
// {/fact}