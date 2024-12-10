// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-in-secure-cookie@v1.0 defects=1}
const cookieSession = require('cookie-session');
const express = require('express');
const csrf = require('csurf');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());

// Noncompliant: Cookie session configured with secure flag set to `false`, allowing cookies to be transmitted over insecure HTTP connections.
app.use(
    cookieSession({
      name: 'session',
      secret: 'your-secret-key',
      httpOnly: true,
      secure: false,
      maxAge: 24 * 60 * 60 * 1000
    })
);

app.use(csrf());

app.get('/', (req, res) => {
  res.send(`CSRF Token: ${req.csrfToken()}`);
});
// {/fact}