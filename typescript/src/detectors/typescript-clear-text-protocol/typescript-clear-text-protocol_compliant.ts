// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-clear-text-protocol@v1.0 defects=0}
import ftpClient from "ftpd";

const ipAdd: string = '10.32.245.180';
const hostName: string = 'amazon.com';
const url_ftp_global_var: string = "ftp://anonymous@exemple.com";

function compliant(): void {
    // Compliant: The ftp client is initialized with a clear text protocol.
    ftpClient.request('ftp://127.0.1.1/', (err: Error | null, data: Buffer, res: any) => {
        if (err) {
            throw err; 
        }
    });
}
// {/fact}
