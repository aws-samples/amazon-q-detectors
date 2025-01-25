// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-path-traversal@v1.0 defects=1}
import express, { Request, Response } from 'express';
import path from 'path';

const app = express();

function pathTraversalNoncompliant(): void {
    app.get('/products', (req: Request, res: Response): void => {
        const basePath: string = '/data/product/images/';
        // Noncompliant: User-supplied path is not sanitized and could contain malicious characters.
        const targetPath: string = path.join(basePath, req.query.path as string);
        retrieveProduct(targetPath);
        res.send('Here is your requested product!');
    });
}
// {/fact}
