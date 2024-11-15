// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-xpath-injection@v1.0 defects=1}
var express = require('express')
var xpath = require('xpath')
var dom = require('xmldom').DOMParser
var app = express()

function noncompliant() {
    app.get('www.example.com', function(req, res) {
        var userName = req.params.userName
        var xml = "<book><title>Harry Potter</title></book>"
        var doc = new dom().parseFromString(xml)
        // Noncompliant: Passing user-input directly in an `XPath` expression.
        var nodes = xpath.select("//title" + userName, doc)
    })
}
// {/fact}
