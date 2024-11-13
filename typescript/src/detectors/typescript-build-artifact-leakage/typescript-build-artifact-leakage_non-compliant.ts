// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-build-artifact-leakage@v1.0 defects=1}
import { DefinePlugin } from 'webpack';

function buildArtifactLeakageNoncompliant() {
    // Noncompliant: Exposing all environment variables, potentially including sensitive information.
    const definePlugin = new DefinePlugin({
        'process.env': JSON.stringify(process.env)
    });
}
// {/fact}
