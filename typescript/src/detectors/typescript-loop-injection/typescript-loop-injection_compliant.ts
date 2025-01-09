// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-loop-injection@v1.0 defects=0}
import express from 'express';

const app = express();

app.post("/list-users", (req: express.Request, res: express.Response) => {
    const obj = req.body;
    const someArr: any[] = [];
    // Compliant: Checks array length before iteration, preventing potential DoS attacks from excessively large inputs.
    if (Array.isArray(obj) && obj.length > 0 && obj.length < 1000) {
        for (let i = 0; i < obj.length; i++) {
            someArr.push(obj[i]);
        }
    }
});
// {/fact}
