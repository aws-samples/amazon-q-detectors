// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-file-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import fs from 'fs';

const app = express();

function fileInjectionCompliant() {
    app.get('www.example.com/:data', (req: Request, res: Response) => {
        var data = sanitize(req.params.data);
        // Compliant: User input is sanitized before use.
        fs.writeFile('data.txt', data, (err: Error | null) => {
            if (err) throw err;
        });
    });
}
// {/fact}
