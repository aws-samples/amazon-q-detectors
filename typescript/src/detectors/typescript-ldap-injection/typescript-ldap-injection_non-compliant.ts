// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-ldap-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
import cookieParser from 'cookie-parser';
import csrf from 'csurf';
import ldap from 'ldapjs';
import { authenticate } from 'ldap-authentication';

const app: express.Application = express();

app.use(cookieParser());

const csrfProtection = csrf();
app.use(csrfProtection);

const client: ldap.Client = ldap.createClient({
    url: 'ldap://127.0.0.1:1389'
});

app.get("/query", async (req: Request, res: Response): Promise<void> => {
    // Noncompliant: Unsanitized user input is used as part of a filter for an LDAP search query.
    const username: string = req.body.username;
    const userDn: string = 'uid=' + username + ',dc=example,dc=com';
    const userPassword: string = 'password';

    const authenticated: boolean = await authenticate({
        ldapOpts: { url: 'ldap://ldap.amazon.com' },
        userDn: userDn,
        userPassword: userPassword
    });

    res.send(authenticated ? 'User authenticated' : 'Authentication failed');
});
// {/fact}
