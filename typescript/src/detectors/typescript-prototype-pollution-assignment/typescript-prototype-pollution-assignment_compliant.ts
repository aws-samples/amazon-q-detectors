// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-prototype-pollution-assignment@v1.0 defects=0}
import express, { Request, Response } from 'express';

const app = express();

function insecureObjectAttributeModificationCompliant() {
    app.get('www.example.com/:id', (req: Request, res: Response) => {
        var userId = req.params.id;
        // Compliant: Checks the type of `userId` as string.
        if (typeof userId === 'string') {
            req.session.user[userId] = req.body['userDetails'];
        }
    });
}
// {/fact}
