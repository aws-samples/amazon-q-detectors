// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-avoid-escaping-for-untrusted-user-input@v1.0 defects=1}
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import Handlebars from 'handlebars';
import express, { Request, Response } from 'express';
import fetch from 'node-fetch';

const app = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

async function compliant(): Promise<Handlebars.SafeString> {
    try {
        const response = await fetch("link");
        const data = await response.json();
        // Noncompliant: Using `Handlebars.SafeString()` with untrusted user input without escaping can lead to XSS vulnerabilities.
        return new Handlebars.SafeString(data);
    } catch (error) {
        console.error("Error in compliant function:", error);
        throw error;
    }
}

app.get('/secure', async (req: Request, res: Response) => {
    try {
        const data = await compliant();
        res.json({ data });
    } catch (error) {
        res.status(500).send("An error occurred while processing your request.");
    }
});

const PORT: number = process.env.PORT ? parseInt(process.env.PORT) : 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
// {/fact}
