// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-ldap-injection@v1.0 defects=0}
import { authenticate } from 'ldap-authentication';
import * as ldap from 'ldapjs';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';
import express, { Request, Response } from 'express';

const app: express.Express = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

const client: ldap.Client = ldap.createClient({
    url: 'ldap://127.0.0.1:1389'
});

function sanitizeInput(input: string): string {
    if (typeof input !== 'string') {
        throw new Error('Invalid input: must be a string');
    }

    const sanitized: string = input.replace(/[^a-zA-Z0-9\-_.]/g, '');

    if (sanitized.length > 50) {
        throw new Error('Input is too long');
    }

    return sanitized;
}

app.get("/query", async (req: Request, res: Response): Promise<void> => {
    try {
        // Compliant: User input is sanitized before being used as part of a filter for an LDAP search query.
        const username: string = sanitizeInput(req.query.username as string);
        const authenticated: boolean = await authenticate({
            ldapOpts: { url: 'ldap://ldap.amazon.com' },
            userDn: 'uid=' + username + ',dc=example,dc=com',
            userPassword: 'password'
        });

        res.send(authenticated ? 'User authenticated' : 'Authentication failed');
    } catch (error) {
        res.status(400).send(`Error: ${error.message}`);
    }
});
// {/fact}
