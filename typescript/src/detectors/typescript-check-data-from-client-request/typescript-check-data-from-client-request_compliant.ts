// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-check-data-from-client-request@v1.0 defects=0}
import express, { Request, Response } from 'express';
import DOMPurify from 'dompurify';

const app = express();

function compliant() {
    app.get('/someurl', function (request: Request, response: Response) {
        // Compliant: Sanitized the input before setting it as a cookie value.
        const sanitizedBody = DOMPurify.sanitize(String(request.query.body));
        response.cookie("body", sanitizedBody);
    });
}
// {/fact}
