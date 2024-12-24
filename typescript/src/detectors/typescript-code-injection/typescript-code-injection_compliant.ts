// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-code-injection@v1.0 defects=0}
import express, { Request, Response } from 'express';
import axios from 'axios';

const app = express();

function compliant(): void {
    app.get("/add", function (req: Request, res: Response): void {
        // Compliant: Trusted user input is being passed into dynamically executable code.
        let calculated: number = eval("2 + 3");
        res.send("Addition has been calculated");
    });
}

// {/fact}
