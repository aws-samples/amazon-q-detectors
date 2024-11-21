// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-file-injection@v1.0 defects=0}
var fs = require('fs')
var express = require('express')
var app = express()

function compliant() {
    app.get('www.example.com', (req, res) => {
        var data = sanitize(req.params.data)
        // Compliant: User input is sanitized before use.
        // Compliant: `sanitize()` method is used to clean user input before use.
        fs.writeFile('data.txt', data, function(err){
            if(err) throw err
        })
    })
}
// {/fact}
