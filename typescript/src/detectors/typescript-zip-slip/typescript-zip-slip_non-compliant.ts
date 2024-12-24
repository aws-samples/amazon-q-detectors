// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-zip-slip@v1.0 defects=1}
import AdmZip from 'adm-zip';
import fs from 'fs';

function nonCompliant(): void {
    const adm = new AdmZip("./zip-slip.zip");
    const zipEntries = adm.getEntries();
    zipEntries.forEach(function (zipEntry: AdmZip.IZipEntry) {
        // Noncompliant: Creating file paths from untrusted input.
        fs.createWriteStream(zipEntry.entryName);
    });
}
// {/fact}
