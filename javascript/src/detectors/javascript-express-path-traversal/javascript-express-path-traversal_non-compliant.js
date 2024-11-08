// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-path-traversal@v1.0 defects=1}
var express = require('express')
var app = express()
var path = require('path')
function pathTraversalNoncompliant() {
    app.get('/products', (req, res) => {
        const basePath = '/data/product/images/'
        // Noncompliant: User-supplied path is not sanitized and could contain malicious characters.
        var targetPath = path.join(basePath, req.query.path)
        retrieveProduct(targetPath)
        res.send('Here is your requested product!')
    })
}
// {/fact}
