// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-avoid-escaping-for-untrusted-user-input@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const Handlebars = require('handlebars');
const express = require("express");
const fetch = require('node-fetch');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

function compliant() {
    return fetch("link")
        .then(response => response.json())
        // Compliant: Uses `Handlebars.escapeExpression()` to properly sanitize untrusted data before sending to client, preventing XSS vulnerabilities.
        .then(data => Handlebars.escapeExpression(data))
        .catch(error => {
            console.error("Error in compliant function:", error);
            throw error;
        });
}

app.get('/secure', (req, res) => {
    compliant()
        .then(sanitizedData => {
            res.json({ data: sanitizedData });
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
