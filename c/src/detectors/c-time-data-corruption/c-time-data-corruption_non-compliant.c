// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-time-data-corruption@v1.0 defects=1}
#include <time.h>

void noncompliant()
{
    // Noncompliant: Storing `time_t` value in smaller int type causes data truncation.
    int timestamp = time(NULL);
}
// {/fact}
