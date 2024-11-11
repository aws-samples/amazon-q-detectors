// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=cpp-pointer-subtraction@v1.0 defects=0}
#include <cstring> 

void compliant(char *tmp, char *ptr1, char *ptr2)
{
    // Compliant: Using a constant size avoids pointer arithmetic issues.
	memcpy(tmp, ptr1, 2);
}
// {/fact}
