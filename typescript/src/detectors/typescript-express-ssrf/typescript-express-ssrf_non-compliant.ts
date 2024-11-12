// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-ssrf@v1.0 defects=1}
import express, { Request, Response } from 'express';
import request from 'request';

const app = express();

function serverSideRequestForgeryNoncompliant() {
    app.get('/data/img', (req: Request, res: Response) => {
        var url = req.body.imageUrl;
        // Noncompliant: User provided `url` is used to make a request.
        request.get(url);
    })
}
// {/fact}
