// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-bodyparser@v1.0 defects=1}
import express, { Application } from 'express';
import bodyParser from 'body-parser';

const app: Application = express();

const configureApp = (): void => {
    app.set("port", process.env.PORT || 3000);
    app.set("views", __dirname + "/views");
    app.set("view engine", "jade");
    app.use(express.favicon());
    app.use(express.logger("dev"));
    // Noncompliant: BodyParser is deprecated.
    app.use(express.bodyParser()); 
};

configureApp();
// {/fact}
