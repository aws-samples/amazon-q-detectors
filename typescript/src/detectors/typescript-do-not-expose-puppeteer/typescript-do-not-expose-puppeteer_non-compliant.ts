// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-expose-puppeteer@v1.0 defects=1}
import puppeteer from 'puppeteer';
import express, { Request, Response } from 'express';

const app = express();

// Noncompliant: Remote debugging is enabled, which could cause security issues in production environments.
app.get("/", async (req: Request, res: Response) => {
    try {
        const browser = await puppeteer.launch({args: ['--remote-debugging-address=123', '--something-else']});
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
