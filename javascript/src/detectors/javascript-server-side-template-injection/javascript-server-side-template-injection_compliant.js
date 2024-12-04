// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-server-side-template-injection@v1.0 defects=0}
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

    let allowedVariants = ["https://docs.aws.amazon.com", "https://docs.aws.com", "https://docs.amazon.aws.com"];

    if (allowedUrls.indexOf(url) !== -1) {
        // Compliant: User controlled input is validated before using it for making a server side request.
        request.get("https://docs.aws.amazon.com")
            .then(response => {
                res.status(200).send('Image data fetched successfully. Check logs for details.');
            })
            .catch(error => {
                res.status(500).send('An error occurred while fetching the image data');
        });
    } else {
        res.status(400).send('Invalid URL');
    }
});
// {/fact}
