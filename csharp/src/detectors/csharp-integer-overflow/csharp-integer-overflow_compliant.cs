// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-integer-overflow@v1.0 defects=0}
using System;

namespace OverFlow.Compliant
{
    public class IntegerOverflow
    {
        public void IntegerOverflowCompliant()
        {
            long data;
            // Compliant: Use a hardcoded number that won't cause overflow.
            data = 2;
            long result = (long)(data + 1);
            Console.WriteLine("Compliant result: " + result);
        }
        public static void Main(string[] args)
        {
            IntegerOverflow calculator = new OverFlow.Compliant.IntegerOverflow();
            calculator.IntegerOverflowCompliant();
        }
    }
}
// {/fact}