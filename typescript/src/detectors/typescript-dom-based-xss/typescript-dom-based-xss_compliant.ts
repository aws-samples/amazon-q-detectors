// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-dom-based-xss@v1.0 defects=0}
function compliant(link: string): void {
  const clean = link.replace(/"/g, '&quot;');
  // Compliant: Properly escapes double quotes in user input before DOM manipulation, preventing HTML injection and XSS attacks.
  document.write('<img src="' + clean + '"></img>');
}
// {/fact}
