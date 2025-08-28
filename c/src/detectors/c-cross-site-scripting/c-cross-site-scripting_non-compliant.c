// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=c-cross-site-scripting@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void noncompliant()
{
    char user_input[100];
    strcpy(user_input, "<img src='x' onerror='alert(1)'>");
    
    // Noncompliant: Unsanitized user input in HTML output enables XSS attacks.
    printf("<html><body>Image: %s</body></html>\n", user_input);
}
// {/fact}
