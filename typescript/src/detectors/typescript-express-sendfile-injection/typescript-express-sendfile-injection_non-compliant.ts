// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-sendfile-injection@v1.0 defects=1}
import express, { Request, Response } from "express";

const app = express();

function sendfileInjectionNoncompliant() {
    app.get('www.example.com/:file', (req: Request, res: Response) => {
        var fileName = req.params.file;
        // Noncompliant: Tainted data is passed into `res.sendfile`.
        res.sendFile(fileName);
    });
}
// {/fact}
