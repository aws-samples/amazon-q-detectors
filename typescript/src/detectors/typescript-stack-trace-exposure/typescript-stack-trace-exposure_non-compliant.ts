// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-stack-trace-exposure@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

function stackTraceExposureNoncompliant() {
    app.get('www.example.com', (req: Request, res: Response) => {
        try {
            throw new Error('');
        }
        catch (e:unknown | any) {
            var stackTrace = e.stack || e.stacktrace;
        }
        // Noncompliant: Sending stack trace details in response exposes sensitive internal application information to clients.
        res.send(stackTrace);
    });
}
// {/fact}
