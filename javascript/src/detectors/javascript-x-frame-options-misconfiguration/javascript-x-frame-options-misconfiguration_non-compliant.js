// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-x-frame-options-misconfiguration@v1.0 defects=1}
const express = require('express');
const app = express();

app.get('/test', function (req, res) {
    // Noncompliant: X-Frame-Options header value is dynamically set based on user input, which could allow malicious manipulation.
    res.set('X-Frame-Options', req.query.opts)
    res.send('ok')
});
// {/fact}
