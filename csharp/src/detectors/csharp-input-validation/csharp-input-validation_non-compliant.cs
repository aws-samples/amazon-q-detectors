// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-input-validation@v1.0 defects=1}
using System;
using System.Web.Mvc;

namespace Validation.NonCompliant
{
    public class MethodInputValidation
    {
        [HttpPost]
        [ValidateAntiForgeryToken]
        // Noncompliant: Disabling input validation for the method.
        [ValidateInput(false)]
        public ActionResult MethodInputValidationNoncompliant(string input)
        {
            return new ContentResult { Content = "Input processed without validation." };
        }
    }
}
// {/fact}