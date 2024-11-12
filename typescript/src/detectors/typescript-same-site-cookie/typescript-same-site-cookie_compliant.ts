// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-same-site-cookie@v1.0 defects=0}
import express, { Request, Response } from 'express';

const app = express();

function crossSiteRequestForgeryCompliant() {
    app.get("/", (req: Request, res: Response) => {
        // Compliant: `sameSite` is set to `lax`.
        res.cookie('cookieName', 'cookieValue', { sameSite: 'lax', secure: true });
        res.render("index.html");
    });
}
// {/fact}
