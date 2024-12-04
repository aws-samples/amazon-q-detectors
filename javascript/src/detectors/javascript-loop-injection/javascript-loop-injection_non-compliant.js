// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-loop-injection@v1.0 defects=1}
const csrf = require('csurf');
const cookieParser = require('cookie-parser');
const express = require('express');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.post("/list-users", (req, res) => {
    let obj = req.body.users;
    let someArr = [];

    // Noncompliant: Object received from user-input is looped over without verification.
    for (let i = 0; i < obj.length; i++) {
        someArr.push(obj[i]);
    }

    res.send(someArr);
});
// {/fact}
