/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=javascript-http-no-refer-policy@v1.0 defects=1}
var express = require('express')
var helmet = require('helmet')
var app = express()
function sensitiveInformationLeakNoncompliant(){
    app.use(
        helmet.referrerPolicy({
            // Noncompliant: Configures the `policy` as `no-referrer-when-downgrade`, risking exposure of sensitive information.
            policy: 'no-referrer-when-downgrade'
        })
    )
}
// {/fact}
