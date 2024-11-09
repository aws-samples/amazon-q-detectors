// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-incorrect-pseudorandom-number-generator@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

enum { len = 12 };

void noncompliant() 
{
	char id[len];
	int r;
	int num;

	// Noncompliant: rand() generates predictable values and should be avoided.
	r = rand();
	num = snprintf(id, len, "ID%-d", r);
}
// {/fact}
