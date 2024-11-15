// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-crypto-timing-attack@v1.0 defects=0}
var express = require('express')
var app = express()
var compare = require('secure-compare')

function compliant() {
    app.get('/user/login', function (req, res) {
        // Compliant: Sensitive data field is compared using `secure-compare`.
        if(compare(password, "myPass")) {
            logIn()
        }
    })
}
// {/fact}
