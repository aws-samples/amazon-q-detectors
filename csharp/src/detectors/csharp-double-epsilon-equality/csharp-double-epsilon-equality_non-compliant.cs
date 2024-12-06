// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-double-epsilon-equality@v1.0 defects=1}
using System;
namespace DoubleEpsilonEquality.NonCompliant
{
    public class Example
    {
        public bool LazyEqualLeftCompare(double v1, double v2)
        {
            // Noncompliant: Performs direct double comparison without using Epsilon, which can lead to inaccurate results.
            return Math.Abs(v1 - v2) <= Double.Epsilon;
        }
    }
}
// {/fact}