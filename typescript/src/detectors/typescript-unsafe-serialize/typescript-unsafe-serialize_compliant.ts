// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unsafe-serialize@v1.0 defects=0}
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import serialize from 'serialize-javascript';

const app = express();
app.use(cookieParser());
app.use(csrf());

app.get("/query", (req: Request, res: Response) => {
    const data = req.body;
    // Compliant: Using serialize-javascript library for safe serialization of data prevents code injection and prototype pollution attacks.
    const serializedData = serialize({ foo: data }, { space: 2 });
    res.setHeader('Content-Type', 'application/json');

    res.json({ result: serializedData });
});
// {/fact}
