// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dns-prefetching@v1.0 defects=0}
var express = require('express')
var helmet = require('helmet')
var app = express()

function dnsPrefetchingCompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Compliant: `allow` is set to `false`.
            allow: false
        })
    )
}
// {/fact}
