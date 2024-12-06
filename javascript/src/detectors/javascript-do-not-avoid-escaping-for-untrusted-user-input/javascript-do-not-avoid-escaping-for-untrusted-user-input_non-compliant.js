// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

//{fact rule=javascript-do-not-avoid-escaping-for-untrusted-user-input@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const Handlebars = require('handlebars');
const express = require("express");
const fetch = require('node-fetch');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

function nonCompliant() {
    return fetch("link")
        .then(response => response.json())
        // Noncompliant: Using `Handlebars.SafeString()` with untrusted user input without escaping can lead to XSS vulnerabilities.
        .then(data => Handlebars.SafeString(data))
        .catch(error => {
            console.error("Error in compliant function:", error);
            throw error;
        });
}

app.get('/secure', (req, res) => {
    compliant()
        .then(data => {
            res.json({ data: data });
        })
        .catch(error => {
            res.status(500).send("An error occurred while processing your request.");
        });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
// {/fact}
