// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-serve-static@v1.0 defects=0}
import express from 'express';
import serveStatic from 'serve-static';

const app = express();

function fileAndDirectoryInformationExposureCompliant(safeDomain: string): void {
    // Compliant: `dotfiles` option is configured as `ignore` to prevent serving hidden files.
    const serveStaticMiddleware = serveStatic('public', { index: false, dotfiles: 'ignore' });
    app.use(serveStaticMiddleware);
}
// {/fact}
