// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-regenerate-session@v1.0 defects=1}
import express, { Request, Response } from 'express';
import passport from 'passport';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app = express();
app.use(cookieParser());
const csrfProtection = csrf({
    cookie: {
        secure: true,
        httpOnly: true, 
        sameSite: 'strict',
        domain: 'yourdomain.com',
        path: '/somepage'
    }
});

app.post('/somepage',
    csrfProtection,
    passport.authenticate('local', { failureRedirect: '/somepage' }),
    function(req: Request, res: Response) {
        // Noncompliant: Session is not regenerated after `passport.authenticate()`.
        res.redirect('/');
    });

// {/fact}
