// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-ldap-injection@v1.0 defects=1}
const { authenticate } = require('ldap-authentication');
const ldap = require('ldapjs');
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

const client = ldap.createClient({
    url: 'ldap://127.0.0.1:1389'
});

app.get("/query" ,async (req, res) => {
    // Noncompliant: Unsanitized user input is used as part of a filter for an LDAP search query.
    let authenticated = await authenticate({
        ldapOpts: { url: 'ldap://ldap.amazon.com' },
        userDn: 'uid=' + req.body.username + ',dc=example,dc=com',
        userPassword: 'password'});

    res.send(authenticated ? 'User authenticated' : 'Authentication failed');
});
// {/fact}
