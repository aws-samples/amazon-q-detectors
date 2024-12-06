// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-prototype-pollution-function@v1.0 defects=0}
function compliant(dst, src) {
    // Compliant: Properly checks object ownership using `hasOwnProperty()` to prevent prototype pollution during object merging.
    for (let key in src) {
        if (!src.hasOwnProperty(key)) continue;
        if (dst.hasOwnProperty(key) && isObject(dst[key])) {
            compliant(dst[key], src[key]);
        } else {
            dst[key] = src[key];
        }
    }
}
// {/fact}
