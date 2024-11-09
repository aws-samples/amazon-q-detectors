// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-off-by-one@v1.0 defects=1}
#include <stdio.h>

void noncompliant() {
    int id_sequence[3];

    id_sequence[0] = 123;
    id_sequence[1] = 234;
    id_sequence[2] = 345;
    // Noncompliant: Attempting to access index 3 out of bound.
    id_sequence[3] = 456;
}
// {/fact}
