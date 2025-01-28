// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-wkhtml-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import wkhtmltopdf from 'wkhtmltopdf';

const app = express();

app.get('/', async function(req: Request, res: Response): Promise<void> {
    // Noncompliant: User input is directly used in `wkhtmltopdf`.
    const pdf = wkhtmltopdf(req.query.q as string, { output: 'vuln.pdf' });
    res.send(pdf);
});
// {/fact}
