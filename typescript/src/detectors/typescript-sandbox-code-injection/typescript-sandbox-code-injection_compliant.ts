// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-sandbox-code-injection@v1.0 defects=0}
import { Request, Response, NextFunction } from 'express';
import express from 'express';
import Sandbox from 'sandbox';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/user/:temp', (req: Request, res: Response) => {
    const s = new Sandbox();
    // Compliant: Using sandbox environment with CSRF protection to safely execute code and prevent unauthorized code injection attacks.
    s.run('input("anyinput")', (output: string) => {
        // Callback function
        console.log(output);
    });
    res.send("Successful!");
});
// {/fact}
