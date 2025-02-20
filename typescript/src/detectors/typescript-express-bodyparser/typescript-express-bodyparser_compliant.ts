// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-bodyparser@v1.0 defects=0}
import express, { Application } from 'express';

const app: Application = express();

const configureApp = (): void => {
    app.set("port", process.env.PORT || 3000);
    app.set("views", __dirname + "/views");
    app.set("view engine", "jade");
    // Compliant: BodyParser has not been used.
    app.use(express.json());
    app.use(express.urlencoded({ extended: true }));
};

configureApp();
// {/fact}
