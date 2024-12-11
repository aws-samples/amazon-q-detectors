// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=csharp-memory-marshal-create-span@v1.0 defects=1}
using System;

public class NonCompliantExample<T>
{
    private T _e0;
    //Noncompliant: Using unsafe code and pointer arithmetic for type conversion, which can lead to memory safety issues.
     public void MarshalTest() {
          Span<T> ToSpan() => MemoryMarshal.CreateSpan(ref _e0, 1);
     }
}
// {/fact}