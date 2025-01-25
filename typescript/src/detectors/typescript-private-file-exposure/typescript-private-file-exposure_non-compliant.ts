// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-private-file-exposure@v1.0 defects=1}
import express, { Express } from 'express';
import path from 'path';

const app: Express = express();

// Noncompliant: `node_modules` is directly exposed.
app.use('/node_modules', express.static(path.resolve(__dirname, '../node_modules')));
// {/fact}
