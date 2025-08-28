// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-unused-assigned-variables@v1.0 defects=0}
int compliant(int y)
{
    // Compliant: Variable assigned once and properly used.
    int x = 200;
    return x + y;
}
// {/fact}
