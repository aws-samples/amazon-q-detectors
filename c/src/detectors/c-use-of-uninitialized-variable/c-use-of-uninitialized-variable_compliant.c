// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-use-of-uninitialized-variable@v1.0 defects=0}
int compliant()
{
    // Compliant: Variable properly initialized before use.
    int x = 5;
    return x + 10;
}
// {/fact}
