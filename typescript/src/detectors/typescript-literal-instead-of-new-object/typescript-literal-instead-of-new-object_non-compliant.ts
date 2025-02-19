// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-literal-instead-of-new-object@v1.0 defects=1}
function nonCompliant(): void {
    // Noncompliant: Using `new Object()` can lead to reduced performance, verbose syntax, and maintenance overhead.
    const obj: any = new Object();
    obj.name = "John";
    obj.age = 17;
}
// {/fact}
