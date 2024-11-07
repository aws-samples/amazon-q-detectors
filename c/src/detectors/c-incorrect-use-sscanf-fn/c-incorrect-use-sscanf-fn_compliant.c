// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-incorrect-use-sscanf-fn@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

int compliant() {
    // Compliant: Use `strtof()` for number conversions.
    const char *float_str = "3.1415";
    float var = strtof(float_str, NULL);
    return 0;
}
// {/fact}