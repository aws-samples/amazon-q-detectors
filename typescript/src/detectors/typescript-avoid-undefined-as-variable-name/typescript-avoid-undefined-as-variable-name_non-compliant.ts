// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-undefined-as-variable-name@v1.0 defects=1}
function variableNameNoncompliant() {
    // Noncompliant: Using `undefined` as a variable name.
    var undefined = "Volvo";
    console.log(undefined);
}
// {/fact}
