// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-expose-puppeteer@v1.0 defects=0}
import puppeteer from 'puppeteer';
import express, { Request, Response } from 'express';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf({ cookie: true });

// Compliant: Disabled remote debugging in production environments and added CSRF protection.
app.post("/", csrfProtection, async (req: Request, res: Response) => {
    try {
        const browser = await puppeteer.launch({args: ['--somethin-else', '--more-examples']});
        const page = await browser.newPage();
        await page.goto('https://example123.com');
        await browser.close();
        res.sendStatus(200);
    } catch (error) {
        console.error('Error:', error);
        res.sendStatus(500);
    }
});

// {/fact}
