// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-use-of-uninitialized-variable@v1.0 defects=1}
int noncompliant()
{
    int x;
    // Noncompliant: Using uninitialized variable.
    return x + 10;
}
// {/fact}
