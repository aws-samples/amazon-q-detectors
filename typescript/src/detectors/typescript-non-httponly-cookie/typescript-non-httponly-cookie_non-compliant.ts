// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-non-httponly-cookie@v1.0 defects=1}
import cookieSession from 'cookie-session';
import express from 'express';

const app = express();

function insecureCookieNoncompliant() {
    let session = app.use(cookieSession({
        name: 'session',
        secret: "secret",
        // Noncompliant: Setting `httpOnly` to `false` makes cookie insecure.
        httpOnly: false,
    }));
}
// {/fact}
