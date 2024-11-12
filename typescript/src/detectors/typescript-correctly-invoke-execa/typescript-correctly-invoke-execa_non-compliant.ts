// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-correctly-invoke-execa@v1.0 defects=1}
import express, { Request } from 'express';
import execa from 'execa';

const app = express();

function osCommandInjectionNoncompliant() {
    app.get('/user/:id', async function (req: Request) {
        // Noncompliant: `execa.command` takes argument as a string, hence it can inject unwanted characters.
        var output = await execa.command("ls -t " + req.params.id);
    });
}
// {/fact}
