// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-undefined-as-variable-name@v1.0 defects=0}
function variableNameCompliant() {
    // Compliant: Renaming variable to avoid using reserved keyword.
    let carBrand = "Volvo";
    console.log(carBrand);
}
// {/fact}
