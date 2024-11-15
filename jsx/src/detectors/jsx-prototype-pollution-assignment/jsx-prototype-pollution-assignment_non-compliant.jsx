// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-prototype-pollution-assignment@v1.0 defects=1}
var express = require('express')
var app = express()

function noncompliant() {
    app.get('www.example.com', (req, res) => {
        var userId = req.params.id
        // Noncompliant: External input modifies object properties, risking prototype pollution.
        req.session.user[userId] = req.body['userDetails']
    })
}
// {/fact}
