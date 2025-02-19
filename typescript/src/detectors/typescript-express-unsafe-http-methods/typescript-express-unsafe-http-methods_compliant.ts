// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-unsafe-http-methods@v1.0 defects=0}
import express, { Express, Request, Response, Router } from 'express';

const app: Express = express();
const router: Router = express.Router();

// Compliant: HTTP routes is not declared using the `all()` method in Express.
app.get("/welcome", function (request: Request, response: Response) {
    response.send("Welcome!!");
});
// {/fact}
