// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-incorrect-xss-protection-header@v1.0 defects=1}

const express = require('express');
const lusca = require('lusca');
const app = express();

app.use(lusca({
    csrf: true,
    csp: { policy: "referrer no-referrer" },
    xframe: 'SAMEORIGIN',
    p3p: 'ABCDEF',
    hsts: { maxAge: 31536000, includeSubDomains: true, preload: true },
    // Noncompliant: `xssProtection` is disabled.
    xssProtection: false,
    nosniff: true,
    referrerPolicy: 'same-origin'
}));
// {/fact}
