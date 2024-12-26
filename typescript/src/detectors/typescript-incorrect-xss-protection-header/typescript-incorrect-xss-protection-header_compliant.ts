// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-incorrect-xss-protection-header@v1.0 defects=0}
import { Express } from 'express';

const express = require('express') as typeof import('express');
const lusca = require('lusca') as typeof import('lusca');

const app: Express = express();

// Compliant: Enabling the browser's XSS filter helps to prevent to XSS attacks.
app.use(lusca({
    csrf: true,
    csp: { policy: "referrer no-referrer" },
    xframe: 'SAMEORIGIN',
    p3p: 'ABCDEF',
    hsts: { maxAge: 31536000, includeSubDomains: true, preload: true },
    xssProtection: true,
    nosniff: true,
    referrerPolicy: 'same-origin'
}));
// {/fact}