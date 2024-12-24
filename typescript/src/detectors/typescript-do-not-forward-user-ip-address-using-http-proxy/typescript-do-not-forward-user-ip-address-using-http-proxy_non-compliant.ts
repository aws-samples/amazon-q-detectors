// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-forward-user-ip-address-using-http-proxy@v1.0 defects=1}
import express from 'express';
import { createProxyMiddleware, RequestHandler } from 'http-proxy-middleware';
import { Request, Response } from 'express';

const app = express();

const nonCompliant = (): void => {
    const app = express();

    const onProxyReq = (proxyRes: Request): void => {
        console.log('req');
    };

    const onProxyRes = (proxyRes: Response): void => {
        console.log('res');
    };

    const getProxy = (): RequestHandler => {
        return createProxyMiddleware({
            target: "API_SERVICE_URL",
            changeOrigin: true,
            onProxyReq,
            onProxyRes,
            // Noncompliant: Setting true for xfwd is insecure.
            xfwd: true
        });
    };

    const PORT: number = 5000;
    const HOST: string = "http://127.0.0.1";

    app.listen(PORT, () => {
        console.log(`Starting Proxy at ${HOST}:${PORT}`);
    });
};

// {/fact}
