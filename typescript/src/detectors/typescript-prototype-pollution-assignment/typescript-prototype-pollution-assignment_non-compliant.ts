// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-prototype-pollution-assignment@v1.0 defects=1}
import express, { Request, Response } from 'express';

const app = express();

function insecureObjectAttributeModificationNoncompliant() {
    app.get('www.example.com/:id', (req: Request, res: Response) => {
        var userId = req.params.id;
        // Noncompliant: External input used as object property.
        req.session.user[userId] = req.body['userDetails'];
    });
}
// {/fact}
