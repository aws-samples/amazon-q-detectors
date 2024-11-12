// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-same-site-cookie@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

function crossSiteRequestForgeryNoncompliant() {
    app.get("/", (req: Request, res: Response) => {
        // Noncompliant: `sameSite` is set to `none`.
        res.cookie('cookieName', 'cookieValue', { sameSite: 'none', secure: true });
        res.render("index.html");
    });
}
// {/fact}
