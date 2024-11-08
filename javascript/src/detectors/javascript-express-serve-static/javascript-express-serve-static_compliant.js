// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-serve-static@v1.0 defects=0}
var express = require('express')
var serveStatic = require("serve-static")
var app = express()

function fileAndDirectoryInformationExposureCompliant(safeDomain)
{
    // Compliant: `dotfiles` option is configured as `ignore` to prevent serving hidden files.
    var serveStaticMiddleware = serveStatic('public', { 'index': false, 'dotfiles': 'ignore' })
    app.use(serveStaticMiddleware)
}
// {/fact}
