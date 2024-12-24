// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-server-side-template-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import * as handlebars from 'handlebars';

const app = express();

app.get('/', function(request: Request, response: Response) {
    const a = 'html code';
    // Compliant: User input concatenate other string is not used in `compile()`.
    handlebars.compile(a + 'hello');
});
// {/fact}
