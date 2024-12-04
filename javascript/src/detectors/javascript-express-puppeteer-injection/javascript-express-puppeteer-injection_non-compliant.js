// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-puppeteer-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const puppeteer = require('puppeteer');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/launch', async (req, res) => {
    const browser_launch = await puppeteer.launch();
    const new_page = await browser_launch.newPage();

    // Noncompliant: User controlled input is passed to the goto function.
    await new_page.goto(`https://${req.query.name}`);

    await new_page.screenshot({path: 'example.png'});
    await browser_launch.close();
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
// {/fact}
