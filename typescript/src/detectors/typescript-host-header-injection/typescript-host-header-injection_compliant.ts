// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-host-header-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import cookieParser from 'cookie-parser';
import csrf from 'csurf';

const app: express.Application = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/', (req: Request, res: Response): void => {
    // Compliant: Host value has been safely sanitized.
    res.redirect('https://' + req.headers.host.replace(/:.*/, '') + '/password-reset');
});
// {/fact}
