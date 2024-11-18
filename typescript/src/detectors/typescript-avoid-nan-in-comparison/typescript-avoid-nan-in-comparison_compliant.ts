// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-nan-in-comparison@v1.0 defects=0}
function nanComparisonCompliant(): void {
    const cars: (string | number)[] = ["Saab", "Volvo", "BMW", NaN];

    for (let i = 0; i < cars.length; i++) {
        console.log(cars[i]);
        // Compliant: Using `Number.isNaN` to properly check for `NaN`.
        if (Number.isNaN(cars[i])) {
            console.log("Compliant: NaN found");
        }
    }
}
// {/fact}
