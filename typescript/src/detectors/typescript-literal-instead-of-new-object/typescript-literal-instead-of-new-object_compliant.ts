// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-literal-instead-of-new-object@v1.0 defects=0}
function compliant(): void {
    // Compliant: Using `{}` instead of `new Object()` can helps us to prevent from reduced performance, verbose syntax, and maintenance overhead.
    const obj: { name: string; age: number } = {
        name: "John",
        age: 17
    };
}
// {/fact}
