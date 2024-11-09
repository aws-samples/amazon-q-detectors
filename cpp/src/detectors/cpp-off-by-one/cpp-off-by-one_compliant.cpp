// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-off-by-one@v1.0 defects=0}
#include <stdio.h>

void compliant() {
    int id_sequence[4];

    id_sequence[0] = 123;
    id_sequence[1] = 234;
    id_sequence[2] = 345;
    // Compliant: This is a valid index within the bounds of the array.
    id_sequence[3] = 456;
}
// {/fact}
