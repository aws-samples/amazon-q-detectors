// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-stack-trace-exposure@v1.0 defects=0}
import express, { Request, Response } from 'express';

const app = express();

function stackTraceExposureCompliant() {
    app.get('www.example.com', (req: Request, res: Response) => {
        try {
            throw new Error('');
        }
        catch (e:unknown | any) {
            var stackTrace = e.stack || e.stacktrace;
        }
        // Compliant: Error handling sends generic response instead of exposing internal stack trace to clients.
        res.send("foo");
    });
}
// {/fact}
