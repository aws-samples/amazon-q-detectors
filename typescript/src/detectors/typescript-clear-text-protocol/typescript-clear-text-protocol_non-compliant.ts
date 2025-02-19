// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-clear-text-protocol@v1.0 defects=1}
import ftpClient from "ftpd";

const ipAdd: string = '10.32.245.180';
const hostName: string = 'amazon.com';
const url_ftp_global_var: string = "ftp://anonymous@exemple.com";

function nonCompliant(): void {
    // Noncompliant: ftp url is hardcoded.
    ftpClient.request(url_ftp_global_var, (err: Error | null, data: any, res: any) => {
        if (err) {
            throw err;
        }
    });
}
// {/fact}
