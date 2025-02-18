// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-express-path-traversal@v1.0 defects=0}
import express, { Request, Response } from 'express';
import path from 'path';

const app = express();

function pathTraversalCompliant(): void {
    app.get('/products', (req: Request, res: Response): void => {
        const basePath: string = '/data/product/images/';
        // Compliant: User-supplied relative-path is sanitized.
        const queryPath: string | null = sanitizer(req.query.path as string);
        if (queryPath) {
            const targetPath: string = path.join(basePath, queryPath);
            retrieveProduct(targetPath);
            res.send('Here is your requested product!');
        } else {
            res.send('Invalid product!');
        }
    });
}

function sanitizer(path: string): string | null {
    return path.match(/^[a-z]+$/) ? path : null;
}
// {/fact}
