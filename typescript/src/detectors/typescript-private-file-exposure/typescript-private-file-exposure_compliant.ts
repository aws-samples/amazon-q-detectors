// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-private-file-exposure@v1.0 defects=0}
import express, { Express } from 'express';

const app: Express = express();

// Compliant: `node_modules` is not directly exposed.
app.use("jquery", express.static('./node_modules/jquery/dist'));
// {/fact}
