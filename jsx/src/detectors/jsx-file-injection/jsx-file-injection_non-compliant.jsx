// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-file-injection@v1.0 defects=1}
var fs = require('fs')
var express = require('express')
var app = express()

function noncompliant() {
    app.get('www.example.com', (req, res) => {
        var data = req.params.data
        // Noncompliant: Writing unsanitized user data to a file.
        fs.writeFile('data.txt', data, function(err){
            if(err) throw err
        })
    })
}
// {/fact}
