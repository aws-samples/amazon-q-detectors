// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regular-expression-dos@v1.0 defects=0}
using System;
using System.Text.RegularExpressions;

namespace RegularExpression.Compliant
{
    public class InefficientRegularExpression
    {
        public void InefficientRegularExpressionCompliant(string str)
        {
            try
            {
                // Compliant: Timeout interval is set for regex creation.
                Regex regex = new Regex("^M(N|C+)+D", RegexOptions.None, TimeSpan.FromSeconds(2));
                Match match = regex.Match(str);
                Console.WriteLine($"Match found: {match.Success}");
            }
            catch (RegexMatchTimeoutException ex)
            {
                Console.WriteLine($"Regex timeout occurred: {ex.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error occurred: {ex.Message}");
            }
        }
    }
    public class Program
    {
        public static void Main(string[] args)
        {
            try
            {
                Console.WriteLine("Testing Regular Expression patterns...");
                var compliant = new InefficientRegularExpression();
                Console.WriteLine("\nTesting Compliant Pattern:");
                compliant.InefficientRegularExpressionCompliant("MCCCCCCCCCD");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Main error: {ex.Message}");
            }
        }
    }
}
 // {/fact}