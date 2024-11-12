// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-permitted-cross-domain-policies@v1.0 defects=0}
import express from 'express';
import helmet from 'helmet';

const app = express();

function improperAccessControlCompliant(){
    app.use(
        helmet.permittedCrossDomainPolicies({
            // Compliant: `permittedPolicies` is set to `none`.
            permittedPolicies: "none",
        })
    );
}
// {/fact}
