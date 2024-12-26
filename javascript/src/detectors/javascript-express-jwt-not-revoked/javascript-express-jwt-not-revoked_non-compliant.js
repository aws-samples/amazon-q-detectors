// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-jwt-not-revoked@v1.0 defects=1}
const express = require('express');
const jwt = require('express-jwt');

const app = express();

// Noncompliant: The `jwt` middleware has a missing `isRevoked` attribute.
app.get('/some_url', jwt({secret: process.env.SECRET}), function (req, res) {
    if (!req.user.admin) return res.sendStatus(401);
    res.sendStatus(200);
});
// {/fact}
