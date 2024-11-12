// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-correctly-invoke-execa@v1.0 defects=0}
import express, { Request } from 'express';
import execa from 'execa';

const app = express();

function osCommandInjectionCompliant() {
    app.get('/user/:id', async function (req: Request) {
        // Compliant: Command arguments for `execa` are defined as elements of array to prevent injection.
        var output = await execa("ls", ["-t", req.params.id]);
    });
}
// {/fact}
