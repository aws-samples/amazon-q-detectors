// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-unsigned-comparison@v1.0 defects=1}
#include <cstddef>

int noncompliant() {
    size_t uvar;

    // Noncompliant: `size_t` variable can never be less than 0.
    if (uvar <= 0)
        return 1;

    return 0;
}
// {/fact}
