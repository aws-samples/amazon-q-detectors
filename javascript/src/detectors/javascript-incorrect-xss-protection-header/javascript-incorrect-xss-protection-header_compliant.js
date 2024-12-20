// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-incorrect-xss-protection-header@v1.0 defects=0}
const express = require('express');
const lusca = require('lusca');
const app = express();

app.use(lusca({
    csrf: true,
    csp: { policy: "referrer no-referrer" },
    xframe: 'SAMEORIGIN',
    p3p: 'ABCDEF',
    hsts: { maxAge: 31536000, includeSubDomains: true, preload: true },
    // Compliant: `xssProtection` is enabled.
    xssProtection: true, 
    nosniff: true,
    referrerPolicy: 'same-origin'
}));
// {/fact}
