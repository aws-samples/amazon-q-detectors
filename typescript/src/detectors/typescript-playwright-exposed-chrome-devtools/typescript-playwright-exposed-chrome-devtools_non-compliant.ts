// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-playwright-exposed-chrome-devtools@v1.0 defects=1}
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import express, { Request, Response } from 'express';
import { chromium } from 'playwright';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

// Noncompliant version
app.get('/start-browser', async (req: Request, res: Response): Promise<void> => {
    try {
        const port = 9222;

        // Noncompliant: Usage of `--remote-debugging-port` arg is not secure
        const browser = await chromium.launch({
            args: [`--remote-debugging-port=${port}`]
        });

        res.send('Chromium started successfully in debug mode.');
    } catch (error) {
        console.error('Failed to start browser:', error);
        res.status(500).send('Failed to start browser');
    }
});

// {/fact}
