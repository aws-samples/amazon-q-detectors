// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-dns-prefetching@v1.0 defects=0}
import express from 'express';
import helmet from 'helmet';

const app = express();

function dnsPrefetchingCompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Compliant: Setting `allow` to `false` prevents browsers from performing DNS prefetching, protecting user privacy.
            allow: false
        })
    );
}
// {/fact}
