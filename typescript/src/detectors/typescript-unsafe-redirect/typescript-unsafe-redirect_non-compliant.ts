// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-unsafe-redirect@v1.0 defects=1}
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app = express();

app.use(cookieParser());
app.use(csrf());
app.use(express.json());

function nonCompliant(): void {
    app.get('/unsafe', function(req: Request, res: Response): void {
        const data = req.params;
        const url = data.url;
        // Noncompliant: Direct use of user-provided URL without validation.
        res.location(url);
    });
}
// {/fact}
