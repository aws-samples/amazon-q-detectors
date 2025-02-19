// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-data-exfilteration@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

app.get("nonCompliant", (req: Request, res: Response): Response => {
    try {
        const targetObject: Record<string, unknown> = {};
        // Noncompliant: User controlled data is passed to `Object.assign`.
        let data: Record<string, unknown> = Object.assign(targetObject, req.query.data);
    }
    catch(err: unknown) {
        console.log(err);
    }
    return res.end("ok");
});
// {/fact}
