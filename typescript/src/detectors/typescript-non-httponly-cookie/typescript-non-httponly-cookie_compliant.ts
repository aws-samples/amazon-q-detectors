// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-non-httponly-cookie@v1.0 defects=0}
import cookieSession from 'cookie-session';
import express from 'express';

const app = express();

function insecureCookieCompliant() {
    // Compliant: By default `httpOnly` is set to `true` and thus makes cookie secure.
    let session = app.use(cookieSession({
        name: 'session',
        secret: "secret",
    }));
}

// {/fact}
