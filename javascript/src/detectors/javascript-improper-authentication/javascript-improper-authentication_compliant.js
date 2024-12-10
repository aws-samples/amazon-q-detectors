// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-improper-authentication@v1.0 defects=0}
const jwt = require('jsonwebtoken');
const express = require('express');
const loginController = express.Router();

const csrf = require('csurf');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

loginController.post('/', async (req, res, next) => {
    try {
        const { email, phonenumber, username } = req.body;

        if (!email || !phonenumber || !username) {
            return res.status(400).json({ error: 'Missing required fields' });
        }

        // Compliant: JSON Web Tokens (JWTs) is signed with the default cipher algorithm which is secure.
        const token = jwt.sign(
            { email, phonenumber, username },
            process.env.JWT_SECRET,
            { expiresIn: '1800s' }
        );

        return res.status(200).json({ token });
    } catch (error) {
        console.error('Error generating token:', error);
        return res.status(500).json({ error: 'Internal server error' });
    }
});
// {/fact}
