// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-insecure-publicly-writable-directories@v1.0 defects=1}
import * as fs from 'fs';

function nonCompliant(): void {
    const tmpFile: string = "/tmp/f";
    // Noncompliant: Manipulating files from a global directory can expose your application to race conditions.
    fs.readFile(tmpFile, 'utf8', (err: NodeJS.ErrnoException | null, data: string) => {
       
    });
}
// {/fact}
