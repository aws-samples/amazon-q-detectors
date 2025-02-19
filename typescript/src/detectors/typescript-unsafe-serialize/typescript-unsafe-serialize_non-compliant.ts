// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unsafe-serialize@v1.0 defects=1}
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import serialize from 'serialize-javascript';

const app = express();

app.use(cookieParser());
app.use(csrf());

interface QueryRequest extends Request {
    params: {
        userinput: string;
    };
}

app.get("/query", (req: QueryRequest, res: Response) => {
    const userInput = req.params.userinput;
    // Noncompliant: Using `{unsafe: true}` option in `serialize()` with user input allows potentially dangerous code execution during deserialization.
    const result = serialize({ foo: userInput }, {unsafe: true, space: 2});
    res.setHeader('Content-Type', 'application/json');
    res.json({ result: result });
});
// {/fact}
