// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-file-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import fs from 'fs';

const app = express();

function fileInjectionNoncompliant() {
    app.get('www.example.com/:data', (req: Request, res: Response) => {
        var data = req.params.data;
        // Noncompliant: Writing unsanitized user data to a file.
        fs.writeFile('data.txt', data, (err: Error | null) => {
            if (err) throw err;
        });
    });
}
// {/fact}
