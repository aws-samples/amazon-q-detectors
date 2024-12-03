// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-limit-on-request-content-length@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Noncompliant: limit on request content length is `> 2mb` in a requests.
app.use(bodyParser.urlencoded({ extended: false, limit: "4mb" }))
// {/fact}
