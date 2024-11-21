// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-cat-for-reading-files@v1.0 defects=0}
import fs from 'fs';

function avoidCatCompliant(filename: string): void {
    // Compliant: Using `fs.readFileSync` to read the file safely.
    try {
        const buffer = fs.readFileSync(filename, 'utf8');
        console.log(buffer);
    } catch (error) {
        console.error(`Error reading file: ${error}`);
    }
}
// {/fact}
