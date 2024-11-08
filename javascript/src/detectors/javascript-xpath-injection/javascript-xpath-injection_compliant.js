// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-xpath-injection@v1.0 defects=0}
var express = require('express')
var xpath = require('xpath')
var dom = require('xmldom').DOMParser
var app = express()

function xpathInjectionCompliant()
{
    app.get('www.example.com', function(req, res) {
        var userName = req.params.userName
        var xml = "<book><title>Harry Potter</title></book>"
        var doc = new dom().parseFromString(xml)
        // Compliant: Sanitized user-input used in `XPath` expression to prevent injection.
        var nodes = xpath.select("//title" + escape(userName), doc)
    })
}
// {/fact}
