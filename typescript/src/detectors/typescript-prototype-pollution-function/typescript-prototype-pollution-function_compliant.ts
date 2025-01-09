// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-prototype-pollution-function@v1.0 defects=0}
function compliant(dst: any, src: any): void {
    // Compliant: Blocking the property names `__proto__` and `constructor.prototype` from being merged or assigned can prevent to prototype pollution vulnerability.
    for (const key in src) {
        if (key === "__proto__" || key === "constructor" || key === "prototype")
            throw new Error("Unsafe key '__proto__', 'constructor', or 'prototype' is detected.");
        if (!Object.prototype.hasOwnProperty.call(src, key)) continue;
        
        if (typeof dst[key] === 'object' && dst[key] !== null && !Array.isArray(dst[key])) {
            compliant(dst[key], src[key]);
        } else {
            dst[key] = src[key];
        }
    }
}
// {/fact}
