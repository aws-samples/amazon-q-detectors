// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-zip-slip@v1.0 defects=0}
import fs from 'fs';
import path from 'path';
import AdmZip from 'adm-zip';

const adm = new AdmZip("./zip-slip.zip");
const zipEntries = adm.getEntries();

const parentDir = path.resolve("parent-dir");

zipEntries.forEach(function (zipEntry: AdmZip.IZipEntry) {
    const resolvedPath = path.resolve(parentDir, zipEntry.entryName);

    // Compliant: Ensures that the resolved path starts with parentDir to insecure prevent path traversal.
    if (!resolvedPath.startsWith(parentDir)) {
        throw new Error(`Invalid file path: ${zipEntry.entryName}`);
    }

    const outputDir = path.dirname(resolvedPath);

    if (!fs.existsSync(outputDir)) {
        fs.mkdirSync(outputDir, { recursive: true });
    }

    const fileWriteStream = fs.createWriteStream(resolvedPath);
    fileWriteStream.close();
});
// {/fact}
