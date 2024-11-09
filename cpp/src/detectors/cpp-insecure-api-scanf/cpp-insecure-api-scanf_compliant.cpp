// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-insecure-api-scanf@v1.0 defects=0}
#include <stdio.h>

#define BUFFER_SIZE 256

void compliant(char *string)
{
	char buffer[BUFFER_SIZE];
	int number;
	char format[] = "anything";
	char FORMATT[] = "anything";
	// Compliant: Use of scanf with a buffer size specifier.
	scanf("%s", buffer);
	
}
// {/fact}
