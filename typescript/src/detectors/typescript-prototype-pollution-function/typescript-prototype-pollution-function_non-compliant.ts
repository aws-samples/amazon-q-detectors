// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-prototype-pollution-function@v1.0 defects=1}
function nonCompliant(dst: any, src: any): void {
    // Noncompliant: Using built-in `Object.prototype` may leads to prototype pollution vulnerability.
    for (const key in src) {
        if (!Object.prototype.hasOwnProperty.call(src, key)) continue;
        
        if (typeof dst[key] === 'object' && dst[key] !== null && !Array.isArray(dst[key])) {
            nonCompliant(dst[key], src[key]);
        } else {
            dst[key] = src[key];
        }
    }
}
// {/fact}
