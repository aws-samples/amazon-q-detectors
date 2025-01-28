// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-multiargs-code-execution@v1.0 defects=0}
import thenify from 'thenify';

function compliant(): void {
    // Compliant: `multiArgs` has a `false` value.
    const params = { multiArgs: false };
    const promise = thenify(function(callback: (err: Error | null, result: string) => void) {
        callback(null, 'foo');
    }, params);
}
// {/fact}
