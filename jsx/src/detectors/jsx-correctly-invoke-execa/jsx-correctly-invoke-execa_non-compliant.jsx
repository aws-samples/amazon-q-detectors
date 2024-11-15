// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-correctly-invoke-execa@v1.0 defects=1}
var express = require('express')
var app = express()
var execa = require('execa')

function noncompliant() {
    app.get('/user/:id', async function (req, res) {
        // Noncompliant: `execa.command` takes argument as a string hence it can inject unwanted characters.
        var output = await execa.command("ls -t "+req.params.id)
    })
}
// {/fact}
