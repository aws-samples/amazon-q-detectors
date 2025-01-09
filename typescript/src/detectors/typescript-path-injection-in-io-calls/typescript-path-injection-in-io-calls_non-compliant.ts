// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-path-injection-in-io-calls@v1.0 defects=1}
import express, { Request, Response } from "express";
import * as fs from 'fs';

const app = express();
app.get("/read", function(req: Request, res: Response) {
    const path: string = "application_dir/" + req.params.name;

    // Noncompliant: Using potentially untrusted inputs to access a file path can lead to path traversal attacks.
    fs.writeFileSync(path, "Completed");

    res.send("DONE");
});
// {/fact}
