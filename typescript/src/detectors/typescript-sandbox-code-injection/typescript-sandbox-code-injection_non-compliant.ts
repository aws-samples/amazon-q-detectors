// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-sandbox-code-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import Sandbox from 'sandbox';
import cookieParser from 'cookie-parser';

const app = express();

app.use(cookieParser());

app.get('/user/:temp', (req: Request, res: Response) => {
    const s = new Sandbox();
    // Noncompliant: Direct concatenation of user input into sandbox code execution creates potential for code injection attacks.
    s.run(`${req.params.temp}`, (output: any) => {
        console.log(output);
    });
    res.send("Successful!");
});

const port = 3000;
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
// {/fact}
