// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-dns-prefetching@v1.0 defects=1}
var express = require('express')
var helmet = require('helmet')
var app = express()

function noncompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Noncompliant: `allow` is set to `true`.
            allow: true
        })
    )
}
// {/fact}
