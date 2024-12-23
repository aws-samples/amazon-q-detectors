// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-playwright-exposed-chrome-devtools@v1.0 defects=0}
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import express, { Request, Response } from 'express';
import { chromium, Browser } from 'playwright';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

app.get('/start-browser', async (req: Request, res: Response): Promise<void> => {
    try {
        if (req.query.enableDebug !== undefined) {
            return res.status(403).send('Debugging is not allowed');
        }

        // Compliant: No usage of `--remote-debugging-port` in the launch arguments
        const browser: Browser = await chromium.launch({
            args: ['--no-sandbox']
        });

        res.send('Chromium started successfully');
    } catch (error) {
        console.error('Failed to start browser:', error);
        res.status(500).send('Failed to start browser');
    }
});
// {/fact}
