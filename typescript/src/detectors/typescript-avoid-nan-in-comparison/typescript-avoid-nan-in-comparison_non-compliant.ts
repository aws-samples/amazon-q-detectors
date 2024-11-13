// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-nan-in-comparison@v1.0 defects=1}
function nanComparisonNoncompliant(): void {
    const cars: (string | number)[] = ["Saab", "Volvo", "BMW", NaN];

    for (let i = 0; i < cars.length; i++) {
        // Noncompliant: Always `false` because `NaN !== NaN`.
        if (cars[i] === NaN) {
            console.log("Noncompliant: NaN found");
        }
    }
}
// {/fact}
