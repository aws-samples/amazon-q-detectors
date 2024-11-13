// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-check-data-from-client-request@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

function noncompliant() {
    app.get('/someurl', function (request: Request, response: Response) {
        // Noncompliant: Directly setting untrusted user input as a cookie value.
        response.cookie("body", String(request.query.body));
    });
}
// {/fact}
