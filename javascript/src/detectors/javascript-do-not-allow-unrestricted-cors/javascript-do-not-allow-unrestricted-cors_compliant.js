// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-allow-unrestricted-cors@v1.0 defects=0}
const http = require("https");

function compliant() {
  const srv = http.createServer((req, res) => {
    // Compliant: CORS policy restricts access to a specific trusted domain rather than allowing all origins, enhancing security.
    res.writeHead(200, { "Access-Control-Allow-Origin": "docs.aws.amazon.com" });
    res.end("ok");
    srv.listen(3000);
  });
}
// {/fact}

  