// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-unserialized-parsed-data@v1.0 defects=1}
import express, { Request, Response } from 'express';
import cookieParser from 'cookie-parser';
import csrf from 'csurf';

const app: express.Express = express();

app.use(cookieParser());
app.use(express.text({ type: "application/json" }));

const csrfProtection = csrf();
app.use(csrfProtection);

app.route("/data")
    .get((req: Request, res: Response): void => {
        res.send("Send a POST request with raw JSON to this endpoint.");
    })
    .post((req: Request, res: Response): void => {
        const jsondata: string = req.body;

        try {
            // Noncompliant: `JSON.parse` is used on user-supplied input.
            const jsonParsed: unknown = JSON.parse(jsondata);

            res.send("JSON parsed successfully!");
        } catch (error) {
            res.status(400).send("Invalid JSON format!");
        }
    });
// {/fact}
