// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-regex-dos-attack@v1.0 defects=0}
import express, { Request, Response } from 'express';

const app = express();

app.get("/ok", (req: Request, res: Response) => {
    // Compliant: The regex pattern is not vulnerable to ReDoS attacks.
    const re = /([a-z]+)+$/;
    let match = re.test('cdbbdbsbz');
});
// {/fact}
