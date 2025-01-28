// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-jwt-not-revoked@v1.0 defects=1}
import express, { Request, Response } from 'express';
import jwt from 'express-jwt';

const app = express();

app.get('/some_url', jwt({secret: process.env.SECRET}), function (req: Request, res: Response) {
    // Noncompliant: The `jwt` middleware has a missing `isRevoked` attribute.
    if (!req.user.admin) return res.sendStatus(401);
    res.sendStatus(200);
});
// {/fact}