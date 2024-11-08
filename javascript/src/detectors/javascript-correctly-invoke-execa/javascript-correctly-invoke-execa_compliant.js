// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-correctly-invoke-execa@v1.0 defects=0}
var express = require('express')
var app = express()
var execa = require('execa')

function osCommandInjectionCompliant() {
    app.get('/user/:id', async function (req, res)  {
        // Compliant: Command arguments for `execa` are defined as elements of array to prevent injection.
        var output = await execa("ls", ["-t", req.params.id])
    })
}
// {/fact}
