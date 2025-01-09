// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-path-injection-in-io-calls@v1.0 defects=0}
import express, { Request, Response } from "express";
import * as fs from 'fs';

const app = express();

app.get("/read", function(req: Request, res: Response) {
    const path: string = "application_dir/" + req.params.name;

    // Compliant: Using sanitized inputs to access a file path can help prevent path traversal attacks.
    if (typeof path === "string" && path.includes('..')) {
        console.error('Invalid characters .. detected in the base path. This path may be vulnerable to a path traversal attack.');
    }
    else {
        fs.writeFileSync(path, "Completed");
    }

    res.send("DONE");
});
// {/fact}
