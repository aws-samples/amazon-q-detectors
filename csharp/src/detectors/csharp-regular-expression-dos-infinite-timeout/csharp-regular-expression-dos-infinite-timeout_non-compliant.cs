// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regular-expression-dos-infinite-timeout@v1.0 defects=1}
using System.Text.RegularExpressions;

namespace RegularExpressionsDosInfiniteTimeout
{
    public class RegularExpressionsDosInfiniteTimeout
    {
        // Noncompliant: Regex is created without a timeout, potentially vulnerable to DoS attacks.
        Regex rgx = new Regex(pattern, RegexOptions.IgnoreCase, TimeSpan.FromHours(1));
    }
}
//{/fact}