// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regular-expression-dos-infinite-timeout@v1.0 defects=0}
using System.Text.RegularExpressions;

namespace RegularExpressionsDosInfiniteTimeout
{
    public class RegularExpressionsDosInfiniteTimeout
    {
        // Compliant: Regex is created with a timeout to prevent potential DoS attacks
        Regex rgx = new Regex(pattern, RegexOptions.IgnoreCase, TimeSpan.FromSeconds(1));
   }
}

//{/fact}