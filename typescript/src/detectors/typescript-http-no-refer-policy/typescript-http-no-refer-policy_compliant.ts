// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-http-no-refer-policy@v1.0 defects=0}
import express from 'express';
import helmet from 'helmet';

const app = express();

function sensitiveInformationLeakCompliant() {
    app.use(
        helmet.referrerPolicy({
            // Compliant: Setting `policy` to `no-referrer` prevents leaking navigation information to other websites.
            policy: 'no-referrer'
        })
    );
}
// {/fact}
