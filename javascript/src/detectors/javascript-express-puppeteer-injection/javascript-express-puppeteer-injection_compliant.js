// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-puppeteer-injection@v1.0 defects=0}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const puppeteer = require('puppeteer');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.post('/launch', async (req, res) => {
    const browser_launch = await puppeteer.launch();
    const page = await browser_launch.newPage();

    // Compliant: User controlled input is not passed to the goto function.
    await page.goto('https://example.com');

    await page.screenshot({path: 'code.png'});
    await browser_launch.close();
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
// {/fact}
