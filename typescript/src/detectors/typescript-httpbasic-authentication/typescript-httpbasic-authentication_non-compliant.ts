// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-httpbasic-authentication@v1.0 defects=1}
import { Request, Response, NextFunction } from 'express';

function nonCompliant(req: Request, res: Response, next: NextFunction): void {
    const authheader = req.headers.authorization;
    console.log(req.headers);

    if (!authheader) {
        const err = new Error('You are not authenticated!') as Error & { status?: number };
        // Noncompliant: Sets an incomplete `WWW-Authenticate` header which may lead to insecure authentication practices.
        res.set('WWW-Authenticate', 'Basic');
        err.status = 401;
        return next(err);
    }
}
// {/fact}
