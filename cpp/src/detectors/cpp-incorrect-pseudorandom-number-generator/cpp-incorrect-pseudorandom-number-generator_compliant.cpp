// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-incorrect-pseudorandom-number-generator@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

enum { len = 12 };

void compliant() 
{
	char id[len];
	int r;
	int num;

	
	struct timespec ts;
	if (timespec_get(&ts, TIME_UTC) == 0) {
	}
	srandom(ts.tv_nsec ^ ts.tv_sec);
	
	// Compliant: random() should be used for generating pseudorandom numbers.
	r = random();
	num = snprintf(id, len, "ID%-d", r);
}
// {/fact}
