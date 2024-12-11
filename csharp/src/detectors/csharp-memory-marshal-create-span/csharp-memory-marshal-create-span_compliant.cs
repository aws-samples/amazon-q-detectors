// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-memory-marshal-create-span@v1.0 defects=0}
using System;

public class CompliantExample
{
    //Compliant: Using `MemoryMarshal.Cast` for safe conversion between spans of different types.
     public void MarshalTest() {
            Span<int> intSpan = MemoryMarshal.Cast<byte, int>(byteSpan);
     }
}
//{/fact}

