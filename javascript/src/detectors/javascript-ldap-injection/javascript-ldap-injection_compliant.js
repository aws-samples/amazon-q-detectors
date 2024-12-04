// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-ldap-injection@v1.0 defects=0}
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

function sanitizeInput(input) {
    if (typeof input !== 'string') {
        throw new Error('Invalid input: must be a string');
    }

    const sanitized = input.replace(/[^a-zA-Z0-9\-_.]/g, '');

    if (sanitized.length > 50) {
        throw new Error('Input is too long');
    }

    return sanitized;
}

app.get("/query" ,async (req, res) => {
    try {
        // Compliant: User input is sanitized before being used as part of a filter for an LDAP search query.
        let authenticated = await authenticate({
            ldapOpts: {url: 'ldap://ldap.amazon.com'},
            userDn: 'uid=' + sanitizeInput(req.query.username) + ',dc=example,dc=com',
            userPassword: 'password'
        });

        res.send(authenticated ? 'User authenticated' : 'Authentication failed');
    } catch (error) {
        res.status(400).send(`Error: ${error.message}`);
    }
})
// {/fact}
