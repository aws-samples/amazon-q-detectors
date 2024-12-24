// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-httpbasic-authentication@v1.0 defects=0}
import { Request, Response, NextFunction } from 'express';
import crypto from 'crypto';

function compliant(req: Request, res: Response, next: NextFunction): void {
    const authheader = req.headers.authorization;
    console.log(req.headers);

    if (!authheader) {
        const err = new Error('You are not authenticated!') as Error & { status?: number };
        // Compliant: Properly sets `WWW-Authenticate` header and handles authentication securely.
        res.set('WWW-Authenticate', 'Basic realm="' + crypto.randomBytes(20).toString('hex') + '"');
        err.status = 401;
        return next(err);
    }
}
// {/fact}
