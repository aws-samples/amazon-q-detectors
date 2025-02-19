// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-multiargs-code-execution@v1.0 defects=1}
import thenify from 'thenify';

function nonCompliant(): void {
    // Noncompliant: `multiArgs` has a truthy value.
    const params = { multiArgs: '0' };
    const promise = thenify(function(callback: (err: Error | null, result: string) => void) {
        callback(null, 'foo');
    }, params);
}
// {/fact}
