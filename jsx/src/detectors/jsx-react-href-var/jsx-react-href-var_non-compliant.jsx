// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-react-href-var@v1.0 defects=1}
function noncompliant(input) {
  // Noncompliant: Dynamic `href` value could be unsafe.
  const params = {href: input.hi};
  return React.createElement("a", params);
}
// {/fact}
    