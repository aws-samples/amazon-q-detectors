// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-avoid-sensitive-data-in-cookie@v1.0 defects=0}
import express, { Request, Response } from 'express';
import cookieParser from 'cookie-parser';
import crypto from 'crypto';

const app = express();
app.use(cookieParser());
app.use(express.json());

app.post("/compliant", (req: Request, res: Response) => {
    const password = req.body.password;
    const sessionToken = crypto.randomBytes(32).toString('hex');

    // Compliant: Storing a secure session token instead of storing the password.
    res.cookie('session_token', sessionToken, { httpOnly: true, secure: true });
});

app.listen(3000, () => {
    console.log("Server is running on port 3000");
});
// {/fact}
