// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-express-serve-static@v1.0 defects=1}
import express from 'express';
import serveStatic from 'serve-static';

const app = express();

function fileAndDirectoryInformationExposureNoncompliant(): void {
    // Noncompliant: `dotfiles` option is configured as `allow`, exposing hidden files.
    const serveStaticMiddleware = serveStatic('public', { index: false, dotfiles: 'allow' });
    app.use(serveStaticMiddleware);
}

// {/fact}
