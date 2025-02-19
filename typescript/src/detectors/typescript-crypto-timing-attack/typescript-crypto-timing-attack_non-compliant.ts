// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-crypto-timing-attack@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

let password: string;

export default app;

app.get('/', function (req: Request, res: Response) {
    // Noncompliant: Using `==` or `===` operators with sensitive data fields like passwords, api keys, tokens etc can be vulnerable to timing attack.
    if (password === process.env.ENV_VARIABLE) {
        console.log("Password matched");
    }
});
// {/fact}
