// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-xxe-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import expat from 'node-expat';

const app: express.Application = express();
const port: number = 3000;


function compliant(): void {
    app.get('/test', async (req: Request, res: Response): Promise<void> => {
        const parser: expat.Parser = new expat.Parser('UTF-8');
        // Compliant: User-controlled data is being used in XML parser.
        parser.parse('<xml>hardcoded</xml>');
        res.send('Hello World!');
    });
}
// {/fact}
