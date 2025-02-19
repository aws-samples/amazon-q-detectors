// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-code-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
const app = express();

function compliant(): void {
    app.get("/add/:num1/:num2", function (req: Request, res: Response): void {
        const num1 = parseFloat(req.params.num1);
        const num2 = parseFloat(req.params.num2);

        if (isNaN(num1) || isNaN(num2)) {
            res.status(400).send("Invalid input. Please provide valid numbers.");
            return;
        }

        // Compliant: Input is validated and directly used without dynamic execution, avoiding code injection risks.
        const result = num1 + num2;
        res.send(`The result of ${num1} + ${num2} is: ${result}`);
    });
}
// {/fact}