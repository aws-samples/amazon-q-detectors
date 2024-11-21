// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-build-artifact-leakage@v1.0 defects=0}
import { DefinePlugin } from 'webpack';

function buildArtifactLeakageCompliant() {
    // Compliant: Only specific, non-sensitive environment variables are exposed.
    const definePlugin = new DefinePlugin({
        'process.env.API_URL': JSON.stringify(process.env.API_URL),
        'process.env.NODE_ENV': JSON.stringify(process.env.NODE_ENV)
    });
}
// {/fact}
