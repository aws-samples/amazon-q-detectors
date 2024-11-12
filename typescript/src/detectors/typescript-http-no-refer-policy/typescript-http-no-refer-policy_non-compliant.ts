// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-http-no-refer-policy@v1.0 defects=1}
import express from 'express';
import helmet from 'helmet';

const app = express();

function sensitiveInformationLeakNoncompliant() {
    app.use(
        helmet.referrerPolicy({
            // Noncompliant: Setting the `policy` to `no-referrer-when-downgrade` may leak referrer information when navigating from HTTPS to HTTP.
            policy: 'no-referrer-when-downgrade'
        })
    );
}
// {/fact}
