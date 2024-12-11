// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regioninfo-inter-process-write@v1.0 defects=1}
using System;
using System.Globalization;
using System.IO;
using System.IO.Pipes;

namespace RegionInfoExample
{
    public class NonConformantRegionInfo
    {
        public static void Main()
        {
            RegionInfo myRI = new RegionInfo("US");

            using (AnonymousPipeServerStream pipeServer = new AnonymousPipeServerStream(PipeDirection.Out, HandleInheritability.Inheritable))
            {
                using (StreamWriter sw = new StreamWriter(pipeServer))
                {
                    // Noncompliant: Writing the entire `RegionInfo object`, potentially exposing sensitive system information.
                    sw.WriteLine(myRI);
                }
            }
        }
    }
}
// {/fact}