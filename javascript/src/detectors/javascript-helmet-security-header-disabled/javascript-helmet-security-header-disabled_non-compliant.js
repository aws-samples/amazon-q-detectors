// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-helmet-security-header-disabled@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const helmet = require('helmet');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Noncompliant: `frameguard` protection is disabled by setting `false`, leaving application vulnerable to clickjacking attacks.
app.use(helmet({frameguard: false}))
// {/fact}
