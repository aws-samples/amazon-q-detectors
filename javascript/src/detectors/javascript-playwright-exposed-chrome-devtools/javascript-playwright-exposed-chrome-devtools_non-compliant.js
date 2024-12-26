// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-playwright-exposed-chrome-devtools@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const { chromium } = require('playwright');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);


app.get('/start-browser', async (req, res) => {
    try {
        var port = 9222;

        // Noncompliant: Usage of `--remote-debugging-port` arg is not secure and should be used with caution.
        const browser = await chromium.launch({args:[`--remote-debugging-port=${port}`]});

        res.send('Chromium started successfully in debug mode.');
    } catch (error) {
        console.error('Failed to start browser:', error);
        res.status(500).send('Failed to start browser');
    }
});
// {/fact}
