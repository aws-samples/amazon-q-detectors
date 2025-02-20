// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-code-injection@v1.0 defects=1}
import express, { Request, Response } from 'express';
const app = express();

function nonCompliant(): void {
    app.get("/add/:num1/:num2", function (req: Request, res: Response): void {
        // Noncompliant: Untrusted user input is being passed into dynamically executable code.
        eval(req.params.num1 + "+" + req.params.num2);
        res.send("Evaluated the result");
    });
}
// {/fact}
