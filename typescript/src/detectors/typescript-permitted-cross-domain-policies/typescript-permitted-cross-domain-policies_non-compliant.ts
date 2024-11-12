// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-permitted-cross-domain-policies@v1.0 defects=1}
import express from 'express';
import helmet from 'helmet';

const app = express();

function improperAccessControlNoncompliant(){
    app.use(
        helmet.permittedCrossDomainPolicies({
            // Noncompliant: `permittedPolicies` is set to `all`.
            permittedPolicies: "all",
        })
    );
}
// {/fact}
