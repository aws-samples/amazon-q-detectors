// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-regenerate-session@v1.0 defects=0}
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


interface AuthenticatedRequest extends Request {
    session: express.Session & {
        regenerate: (callback: (err: any) => void) => void;
    };
}

app.post('/somepage',
    csrfProtection,
    passport.authenticate('local', { failureRedirect: '/somepage' }),
    function(req: AuthenticatedRequest, res: Response) {
        let previous = req.session;
        // Compliant: Session regenerated after `passport.authenticate()`.
        req.session.regenerate((err: any) => {
            //piece of code after session regenerate
        });
    });
// {/fact}
