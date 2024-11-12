// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-ssrf@v1.0 defects=0}
import express, { Request, Response } from 'express';
import request from 'request';

const app = express();

function serverSideRequestForgeryCompliant() {
    app.get('/data/img', (req: Request, res: Response) => {
        // Compliant: `url` used to make a request is not user provided.
        var url = 'https://example.com';
        request.get(url);
    })
}
// {/fact}
