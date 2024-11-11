// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-insecure-api-scanf@v1.0 defects=1}
#include <stdio.h>

#define BUFFER_SIZE 256

void noncompliant(char *string)
{
	char buffer[BUFFER_SIZE];
	int num;
	char format[] = "anything";
	char FORMAT[] = "anything";
	// Noncompliant: Insecure use of scanf().
	scanf(FORMAT, buffer);
}
// {/fact}
