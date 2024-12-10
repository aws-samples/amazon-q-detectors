// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-ssrf@v1.0 defects=0}
const express = require('express')
const app = express()
const request = require('request')

function processData(data) {
    console.log("Custom processing here ...");
}

app.get('/', (req, res) => {
    const url = 'https://google.com';
    // Compliant: Server side request does not include unsanitized data.
    request.get(url).then(res => {
      processData(res.body)
    });
    res.send("Get request performed ....");
})

// {/fact}
