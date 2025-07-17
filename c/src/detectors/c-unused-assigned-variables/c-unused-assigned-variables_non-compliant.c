// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-unused-assigned-variables@v1.0 defects=1}
int noncompliant(int y)
{
    int x = 0;
    // Noncompliant: Dead store - value 100 is assigned but immediately overwritten.
    x = 100;
    x = 200;
    return x+y;
}
// {/fact}
