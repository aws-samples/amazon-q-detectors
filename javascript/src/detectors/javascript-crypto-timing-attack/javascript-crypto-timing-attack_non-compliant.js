// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-crypto-timing-attack@v1.0 defects=1}
var express = require('express')
var app = express()

function timingAttackNoncompliant() {
    app.get('/user/login', function (req, res) {
        // Noncompliant: `===` operator is used with sensitive data field.
        if(password === "myPass") {
            logIn()
        }
    })
}
// {/fact}
