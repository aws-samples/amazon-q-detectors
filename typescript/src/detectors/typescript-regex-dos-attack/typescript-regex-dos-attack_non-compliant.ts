// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-regex-dos-attack@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

app.get("/not-ok", (req: Request, res: Response) => {
    // Noncompliant: The regex pattern is vulnerable to ReDoS attacks when used with user input.
    const re = /([a-z]+)+$/;
    let match = re.test(req.params.id);
});
// {/fact}
