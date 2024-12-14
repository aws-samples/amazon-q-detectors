// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-avoid-nan-in-comparison@v1.0 defects=0}
for (let i = 0; i < cars.length; i++) {
    console.log(cars[i])
    // Compliant : `isNaN()` function from Number will check for NaN value from array.
    if (Number.isNaN(cars[i])) {  
        console.log("Compliant : NaN found");
    }

}
// {/fact}
