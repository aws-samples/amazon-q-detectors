// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regular-expression-dos@v1.0 defects=1}
using System;
using System.Text.RegularExpressions;

namespace RegularExpression.NonCompliant
{
    public class InefficientRegularExpression
    {
        public void InefficientRegularExpressionNoncompliant(string str)
        {
            try
            {
                // Noncompliant: Timeout interval is not set here.
                Regex regex = new Regex("^M(N|C+)+D");
                Match match = regex.Match(str);
                Console.WriteLine($"Match found: {match.Success}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred: {ex.Message}");
            }
        }
    }
}
 // {/fact}