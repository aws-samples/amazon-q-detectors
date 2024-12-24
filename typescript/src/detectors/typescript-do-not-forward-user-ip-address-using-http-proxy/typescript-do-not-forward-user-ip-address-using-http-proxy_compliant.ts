// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-do-not-forward-user-ip-address-using-http-proxy@v1.0 defects=0}
import { createProxyMiddleware } from 'http-proxy-middleware';
import express from 'express';

const app = express();

app.use(
    createProxyMiddleware("/api", {
        // Compliant: xfwd's defaults value is false.
        target: 'http://localhost:8081/',
        changeOrigin: true,
    })
);
app.listen(3000);

// {/fact}
