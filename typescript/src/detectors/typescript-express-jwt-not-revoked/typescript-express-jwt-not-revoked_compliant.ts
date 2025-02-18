// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-jwt-not-revoked@v1.0 defects=0}
import express, { Request, Response, NextFunction } from 'express';
import isRevoked from './isRevoked';
import jwt from 'express-jwt';

app.get(
    '/some_url',
    jwt({
        secret: process.env.SECRET,
        algorithms: ['HS256'],
        isRevoked: async function (req: Request, payload: any, done: (err: any, revoked: boolean) => void) {
            // Compliant: `isRevoked` attribute is present to check if the token has been revoked.
            try {
                const isTokenRevoked = await isRevoked.checkIfRevoked(payload);
                done(null, isTokenRevoked);
            } catch (err) {
                done(err, true);
            }
        },
    }),
    function (req: Request, res: Response) {
        if (!req.user || !req.user.admin) {
            return res.sendStatus(401);
        }
        res.sendStatus(200);
    }
);
// {/fact}
