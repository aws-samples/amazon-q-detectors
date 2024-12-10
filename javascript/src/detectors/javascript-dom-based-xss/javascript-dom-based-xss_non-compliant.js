// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-dom-based-xss@v1.0 defects=1}
function nonCompliant(link) {
  // Noncompliant: Direct insertion of unescaped user input into `document.write()` enables DOM-based XSS attacks through malicious image source URLs.
  document.write('<img src="' + link + '"></img>');
}
// {/fact}
