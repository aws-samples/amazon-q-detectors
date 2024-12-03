// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-prototype-pollution-function@v1.0 defects=1}
function nonCompliant(dst, src) {
    // Noncompliant: Missing `hasOwnProperty()` check on destination object `dst` allows modification of prototype chain properties.
    for (let key in src) {
        if (!src.hasOwnProperty(key)) continue;
        if (isObject(dst[key])) {
            non_compliant(dst[key], src[key]);
        } else {
            dst[key] = src[key];
        }
    }
}
// {/fact}
