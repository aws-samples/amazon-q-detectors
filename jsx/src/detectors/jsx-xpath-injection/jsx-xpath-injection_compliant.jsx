// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-xpath-injection@v1.0 defects=0}
var express = require('express')
var xpath = require('xpath')
var dom = require('xmldom').DOMParser
var app = express()

function compliant()
{
    app.get('www.example.com', function(req, res) {
        var userName = req.params.userName
        var xml = "<book><title>Harry Potter</title></book>"
        var doc = new dom().parseFromString(xml)
        // Compliant: `escape()` encodes special characters in user input to prevent XPath injection.
        var nodes = xpath.select("//title" + escape(userName), doc)
    })
}
// {/fact}
