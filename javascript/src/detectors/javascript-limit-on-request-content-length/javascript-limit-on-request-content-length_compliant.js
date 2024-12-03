// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-limit-on-request-content-length@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Compliant: limit on request content length is `<= 2mb` requests.
app.use(express.urlencoded({ extended: false, limit: "1mb" }))
// {/fact}
