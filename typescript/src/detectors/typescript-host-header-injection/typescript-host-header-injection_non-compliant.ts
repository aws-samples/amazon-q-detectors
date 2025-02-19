// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-host-header-injection@v1.0 defects=1}
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import express, { Request, Response } from 'express';

const app: express.Application = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/', (req: Request, res: Response): void => {
    // Noncompliant: Direct concatenation of `req.host` in URL construction makes application vulnerable to host header injection attacks.
    res.redirect(`https://${req.headers.host}/password_reset`);
});
// {/fact}
