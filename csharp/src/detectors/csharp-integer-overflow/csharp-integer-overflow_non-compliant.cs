// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-integer-overflow@v1.0 defects=1}
using System;

namespace OverFlow.NonCompliant
{
    public class IntegerOverflow
    {
        public void IntegerOverflowNoncompliant()
        {
            long data;
            data = long.MaxValue;
            // Noncompliant: if `data == long.MaxValue` then this will overflow.
            long result = (long)(data + 1);
            Console.WriteLine("Non-compliant result: " + result);
        }
    }
}
// {/fact}
