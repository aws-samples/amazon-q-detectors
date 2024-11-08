// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-http-no-refer-policy@v1.0 defects=0}
var express = require('express')
var helmet = require('helmet')
var app = express()
function sensitiveInformationLeakCompliant(){
    app.use(
        helmet.referrerPolicy({
            // Compliant: Configures the `policy` as `no-referrer` to prevent leaking sensitive information..
            policy: 'no-referrer'
        })
    )
}
// {/fact}
