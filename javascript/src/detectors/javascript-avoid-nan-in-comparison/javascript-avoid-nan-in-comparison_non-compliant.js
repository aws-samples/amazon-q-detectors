// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-avoid-nan-in-comparison@v1.0 defects=1}
const cars = ["Saab", "Volvo", "BMW", NaN];

for (let i = 0; i < cars.length; i++) {
    // Noncompliant: `isNaN()` is not used.
    if (cars[i] === NaN) {  
        console.log("Noncompliant : NaN found");
    }

}

// {/fact}
