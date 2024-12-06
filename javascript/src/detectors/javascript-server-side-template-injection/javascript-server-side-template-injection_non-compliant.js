// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-server-side-template-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');
const request = require('request');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/', (req, res) => {
    const url = req.body.imageUrl;

    // Noncompliant: User controlled input is used directly within `request`.
    request.get(url)
        .then(response => {
            res.status(200).send('Image data fetched successfully. Check logs for details.');
        })
        .catch(error => {
            res.status(500).send('An error occurred while fetching the image data');
        });
});
// {/fact}
