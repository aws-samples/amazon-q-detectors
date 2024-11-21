// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-dom-based-xss@v1.0 defects=1}
var ESAPI = require('node-esapi')
const DOMPurify = require('dompurify')

function noncompliant(){
  // Noncompliant: Directly writes untrusted input to document without encoding, leading to XSS.
  document.write("UNTRUSTED INPUT: " + document.location.hash)
}
// {/fact}
