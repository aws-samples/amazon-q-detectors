// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-unsafe-http-methods@v1.0 defects=1}
import express, { Express, Request, Response, Router } from 'express';

const app: Express = express();
const router: Router = express.Router();

// Noncompliant: HTTP routes using the `all()` method in Express.
app.all("/welcome", function (request: Request, response: Response) {
    response.send("Welcome!!");
});
// {/fact}
