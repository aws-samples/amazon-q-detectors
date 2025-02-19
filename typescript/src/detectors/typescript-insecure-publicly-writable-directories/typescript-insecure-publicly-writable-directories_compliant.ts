// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-insecure-publicly-writable-directories@v1.0 defects=0}
import * as fs from 'fs';
import * as tmp from 'tmp';

function compliant(): void {
    // Compliant: Manipulating files from a temporary directory can helps to prevent your application to race conditions.
    const tmp_obj: tmp.FileResult = tmp.fileSync();

    fs.readFileSync(tmp_obj.name, 'utf8');
}
// {/fact}
