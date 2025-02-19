// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-regenerate-session@v1.0 defects=1}
const express = require('express');
const passport = require('passport');

const app = express();

app.post('/somepage',
    passport.authenticate('local', { failureRedirect: '/somepage' }),
   function(req, res) {
        // Noncompliant: Session does not regenerated `passport.authenticate()`.
         res.redirect('/');
    });

// {/fact}
