// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-ssrf@v1.0 defects=1}
const express = require('express')
const app = express()
const request = require('request')

function processData(data) {
  console.log("Custom processing here ...");
}

app.get('/', (req, res) => {
  const url = req.body.imageUrl;
  // Noncompliant: Unsanitized user data used directly in a server side request.
  request.get(url).then(res => {
    processData(res.body)
  });
  res.send("Get request performed ....");
});
// {/fact}
