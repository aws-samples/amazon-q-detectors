// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-authorization-bypass@v1.0 defects=1}
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authentication.JwtBearer;

namespace Authorization.NonCompliant
{
    // Noncompliant: Access control checks are missing.
    [AllowAnonymous]
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
    }
}
// {/fact}