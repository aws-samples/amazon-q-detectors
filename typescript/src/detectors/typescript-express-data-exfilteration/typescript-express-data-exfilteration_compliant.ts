// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-data-exfilteration@v1.0 defects=0}
import express, { Request, Response } from 'express';

const app: express.Application = express();

function compliant(req: Request, res: Response): void {
    try {
        const targetObject: Record<string, unknown> = {};
        // Compliant: User control data is not being passed to `Object.assign`.
        let data: Record<string, number> = Object.assign(targetObject, { a: 10 });

    } catch (err) {
        console.log(err);
    }
    res.end("ok");
}
// {/fact}
