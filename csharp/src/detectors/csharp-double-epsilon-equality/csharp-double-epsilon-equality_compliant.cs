// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-double-epsilon-equality@v1.0 defects=0}
using System;

namespace DoubleEpsilonEquality.Compliant
{
    public class Example
    {
        public bool IsZero(double arg)
        {
            double zero = 0;
            // Compliant: Uses recommended double comparison with Epsilon to check if a value is `zero`.
            return Math.Abs(arg - zero) <= Double.Epsilon;
        }

        public static void Main(string[] args)
        {
            var example = new Example();
            bool isZero = example.IsZero(0.0);
            Console.WriteLine($"Is 0.0 zero? {isZero}");
        }
    }
}
// {/fact}