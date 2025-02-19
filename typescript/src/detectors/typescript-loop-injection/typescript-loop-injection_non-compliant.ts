// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-loop-injection@v1.0 defects=1}
import express from 'express';

const app = express();

app.post("/list-users", (req: express.Request, res: express.Response) => {
    const obj = req.body.users;
    const someArr: any[] = [];
    // Noncompliant: Iterates over user input without length validation, potentially leading to DoS attacks or crashes from excessively large inputs.
    for (let i = 0; i < obj.length; i++) {
        someArr.push(obj[i]);
    }
});
// {/fact}
