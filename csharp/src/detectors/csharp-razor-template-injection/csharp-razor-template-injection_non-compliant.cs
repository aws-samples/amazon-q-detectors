// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-razor-template-injection@v1.0 defects=1}
using System;
using System.Web.Mvc;
using RazorEngine;
using RazorEngine.Templating;

namespace RazorVulnerableApp.Controllers
{
    public class VulnerableHomeController : Controller
    {
        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Index(string inert, string razorTpl)
        {
            // Noncompliant: Direct parsing of user input without sanitization, vulnerable to template injection attacks.
            ViewBag.RenderedTemplate = Razor.Parse(razorTpl);
            ViewBag.Template = razorTpl;
            return View();
        }
    }
}
// {/fact}
