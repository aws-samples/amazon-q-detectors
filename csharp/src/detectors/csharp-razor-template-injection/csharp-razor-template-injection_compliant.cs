// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-razor-template-injection@v1.0 defects=0}
using System;
using System.Web.Mvc;
using RazorEngine;
using RazorEngine.Templating;

namespace RazorVulnerableApp.Controllers
{
    public class SafeHomeController : Controller
    {
        [HttpPost]
        [ValidateInput(true)]
        public ActionResult Index(string inter, string razorTpl)
        {
            var junk = SomeFunction(razorTpl);
            // Compliant: User input is processed through `SomeFunction` before being parsed, potentially mitigating template injection risks.
            ViewBag.RenderedTemplate = Razor.Parse(junk);
            ViewBag.Template = razorTpl;
            return View();
        }

        private string SomeFunction(string input)
        {

            return input.ToUpper();
        }
    }
}
// {/fact}
