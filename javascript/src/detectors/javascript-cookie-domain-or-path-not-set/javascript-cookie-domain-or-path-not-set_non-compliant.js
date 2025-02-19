// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-cookie-domain-or-path-not-set@v1.0 defects=1}
const cookieSession = require('cookie-session');

const express2 = require('express');
const app2 = express2()

let sessionOptions6 = cookieSession({
    name: "sessionName",
    keys: ["key1", "key2"],
    cookie: {      
        // Noncompliant: HTTP cookie is being used without setting the `domain` or `path` attribute.
        httpOnly: true,
        path: "/trustedPath",
        expires: new Date(Date.now() + 60 * 60 * 1000)
    }
});

app2.use(sessionOptions6);
// {/fact}
