// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-input-validation@v1.0 defects=0}
using System;
using System.Web.Mvc;

namespace Validation.Compliant
{
    public class MethodInputValidation
    {
        [HttpPost]
        [ValidateAntiForgeryToken]
        // Compliant: Enabling input validation for the method.
        [ValidateInput(true)]
        public ActionResult MethodInputValidationCompliant(string input)
        {
            return new ContentResult { Content = "Input processed securely." };
        }
        
    }
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Running Compliant Input Validation Test");
            
            var validator = new MethodInputValidation();
            string testInput = "<script>alert('test');</script>";
            var result = validator.MethodInputValidationCompliant(testInput);

            Console.WriteLine("Completed Input Validation Test");
        }
    }
}
// {/fact}