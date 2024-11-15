// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-permitted-cross-domain-policies@v1.0 defects=0}
var express = require('express')
var helmet = require('helmet')
var app = express()

function compliant(){
    app.use(
        helmet.permittedCrossDomainPolicies({
            // Compliant: `permittedPolicies` is configured as `none`, ensuring added security.
            permittedPolicies: "none",
        })
    )
}
// {/fact}
