// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-case-sensitive-middleware-path@v1.0 defects=1}
import express, { Request, Response, NextFunction } from 'express';

const app = express();

// Noncompliant: Case-sensitive middleware route is used.
app.use(/\/admin\/.*/, (req: Request, res: Response, next: NextFunction) => {
    if (!req.params.userId) {
        return res.status(400).send("User ID is required.");
    }
    next();
});
// {/fact}
