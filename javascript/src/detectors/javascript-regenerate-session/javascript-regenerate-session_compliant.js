// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-regenerate-session@v1.0 defects=0}
const express = require('express');
const passport = require('passport');

const app = express();


app.post('/somepage',
    passport.authenticate('local', { failureRedirect: '/somepage' }),
    function(req, res) {
        let previous = req.session;
        // Compliant: Session regenerated after `passport.authenticate()`.
        req.session.regenerate((err) => {
            //piece of code after session regenerate
        });
    });
// {/fact}
