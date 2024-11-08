// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-serve-static@v1.0 defects=1}
var express = require('express')
var serveStatic = require("serve-static")
var app = express()

function fileAndDirectoryInformationExposureNoncompliant()
{
    // Noncompliant: `dotfiles` option is configured as `allow`, exposing hidden files.
    var serveStaticMiddleware = serveStatic('public', { index: false, dotfiles: 'allow' })
    app.use(serveStaticMiddleware)
}
// {/fact}
