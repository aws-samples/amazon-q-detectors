// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-sendfile-injection@v1.0 defects=0}
import express, { Request, Response } from "express";
import path from "path";

const app = express();

function sendfileInjectionCompliant() {
    app.get('www.example.com/:file', (req: Request, res: Response) => {
        var fileName = "file.txt";
        if (fileName !== req.params.file) {
            // Compliant: Validated `fileName` before passing into `res.sendFile`.
            res.sendFile(path.resolve(fileName));
            console.log("Valid file name.");
        } else {
            throw new Error("Invalid file name.");
        }
    });
}
// {/fact}
