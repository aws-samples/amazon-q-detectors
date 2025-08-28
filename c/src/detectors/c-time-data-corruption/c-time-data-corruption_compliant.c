// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-time-data-corruption@v1.0 defects=0}
#include <time.h>

void compliant()
{
    // Compliant: Using proper `time_t` type to store time values without data loss.
    time_t timestamp = time(NULL);
}
// {/fact}
