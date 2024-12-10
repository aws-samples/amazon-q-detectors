// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-allow-unrestricted-cors@v1.0 defects=1}

const http = require("https");

function nonCompliant() {
  const srv = http.createServer((req, res) => {
    // Noncompliant: Using wildcard '*' in `Access-Control-Allow-Origin` header allows requests from any domain, creating potential security vulnerabilities.
    res.writeHead(200, { "Access-Control-Allow-Origin": "*" }); //non_conformant
    res.end("ok");
    srv.listen(3000);
  });
}
// {/fact}
