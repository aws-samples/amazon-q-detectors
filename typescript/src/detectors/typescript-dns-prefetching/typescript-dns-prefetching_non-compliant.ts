// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-dns-prefetching@v1.0 defects=1}
import express from 'express';
import helmet from 'helmet';

const app = express();

function dnsPrefetchingNoncompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Noncompliant: Setting `allow` to `true` enables DNS prefetching, which can leak users' browsing patterns.
            allow: true
        })
    );
}
// {/fact}
