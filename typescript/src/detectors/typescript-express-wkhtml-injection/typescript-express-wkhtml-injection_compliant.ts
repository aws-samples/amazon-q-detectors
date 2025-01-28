// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-wkhtml-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import wkhtmltopdf from 'wkhtmltopdf';

let app = express();

app.post('/ok', async (req: Request, res: Response): Promise<void> => {
    // Compliant: Uses static HTML.
    const pdf = wkhtmltopdf('<html></html>', { output: 'vuln.pdf' });
    res.send(pdf);
});
// {/fact}
