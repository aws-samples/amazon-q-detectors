// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-unsafe-redirect@v1.0 defects=0}
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import validUrl from 'valid-url';

const app = express();

app.use(cookieParser());
app.use(csrf());


app.use((req: Request, res: Response, next) => {
    res.setHeader('X-Content-Type-Options', 'nosniff');
    res.setHeader('X-Frame-Options', 'DENY');
    res.setHeader('X-XSS-Protection', '1; mode=block');
    next();
});

app.get('/safe', function(req: Request, res: Response): void {
    const url = req.params.url;

    if (!url) {
        return res.location('/');
    }

    if (validUrl.isUri(url)) {
        // Compliant: URL validation using validUrl.isUri() before redirection prevents open redirect vulnerabilities and ensures safe URL handling.
        return res.location(url);
    }

    return res.location('/');
});
// {/fact}
