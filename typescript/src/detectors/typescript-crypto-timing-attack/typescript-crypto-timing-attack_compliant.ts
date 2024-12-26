// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-crypto-timing-attack@v1.0 defects=0}
import express, { Request, Response } from 'express';
import compare from 'secure-compare';

const app = express();

let password: string;

export default app;

app.get('/', function (req: Request, res: Response) {
    // Noncompliant: Using `compare` helps to prevent to timing attack.
    if (compare(password, process.env.ENV_VARIABLE)) {
        console.log("Password matched");
    }
});
// {/fact}
