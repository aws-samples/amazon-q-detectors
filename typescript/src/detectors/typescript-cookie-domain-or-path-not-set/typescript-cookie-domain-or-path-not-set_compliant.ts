// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cookie-domain-or-path-not-set@v1.0 defects=0}
import cookieSession from 'cookie-session';
import express from 'express';

const appGlobal = express();
const expiryDate = new Date(Date.now() + 60 * 60 * 1000);

appGlobal.use(cookieSession({
    name: "sessionName",
    keys: ["key1", "key2"],
    cookie: {
        httpOnly: true,
        // Compliant: HTTP cookie is being used by setting the `domain` or `path` attribute.
        domain: "trusted.domain.com",
        path: "/trustedPath",
        expires: expiryDate
    }
}));
// {/fact}

