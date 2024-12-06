// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-helmet-security-header-disabled@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const helmet = require('helmet');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Compliant: `frameguard` is properly configured with `deny` action to prevent clickjacking attacks.
app.use(helmet.frameguard({ action: 'deny' }));
// {/fact}
