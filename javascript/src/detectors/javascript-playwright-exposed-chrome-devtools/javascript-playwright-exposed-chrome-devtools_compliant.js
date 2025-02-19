// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-playwright-exposed-chrome-devtools@v1.0 defects=0}
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
        if (req.query.enableDebug !== undefined) {
            return res.status(403).send('Debugging is not allowed');
        }

        // Compliant: No usage of `--remote-debugging-port` in the launch arguments
        const browser = await chromium.launch({
            args: ['--no-sandbox']
        });

        res.send('Chromium started successfully');
    } catch (error) {
        console.error('Failed to start browser:', error);
        res.status(500).send('Failed to start browser');
    }
});
// {/fact}
