// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-pointer-subtraction@v1.0 defects=1}
#include <cstring> 

void noncompliant(char *tmp, char *ptr1, char *ptr2)
{
    // Noncompliant: Subtraction of one pointer from another is prone to errors.
	memcpy(tmp, ptr1, (ptr2 - ptr1) - 1);
}

// {/fact}
