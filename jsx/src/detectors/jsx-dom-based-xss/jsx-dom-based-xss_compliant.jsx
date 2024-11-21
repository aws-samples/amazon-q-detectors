// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-dom-based-xss@v1.0 defects=0}
var ESAPI = require('node-esapi')
const DOMPurify = require('dompurify')

function compliant() {
    const hash = document.location.hash
    
    const safeHashPattern = /^[a-zA-Z0-9_-]+$/
    if (safeHashPattern.test(hash)) {
        // Compliant: Encodes validated, untrusted data before rendering to prevent XSS.
        document.write(ESAPI.encoder().encodeForHTML(hash))
    } else {
        console.error("Invalid input detected in URL hash.")
    }
}
// {/fact}
