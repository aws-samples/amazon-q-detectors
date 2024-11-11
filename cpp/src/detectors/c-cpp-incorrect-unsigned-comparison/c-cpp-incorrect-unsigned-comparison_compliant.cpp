// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cpp-incorrect-unsigned-comparison@v1.0 defects=0}

int compliant() {
    unsigned short uvar;

    // Compliant: Comparing against 0 is fine for `size_t` types variable.
    if (uvar == 0)
        return 1;

    return 0;
}
// {/fact}
