// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-regioninfo-inter-process-write@v1.0 defects=0}
using System;
using System.Globalization;
using System.IO;
using System.IO.Pipes;

namespace RegionInfoExample
{
    public class ConformantRegionInfo
    {
        public static void Main()
        {
            RegionInfo myRI = new RegionInfo(new CultureInfo("en-US", false).LCID);

            using (AnonymousPipeServerStream pipeServer = new AnonymousPipeServerStream(PipeDirection.Out, HandleInheritability.Inheritable))
            {
                using (StreamWriter sw = new StreamWriter(pipeServer))
                {
                    // Compliant: Writing only the Name property of `RegionInfo`, avoiding potential sensitive data exposure.
                    sw.WriteLine(myRI.Name);
                }
            }
        }
    }
}
// {/fact}