// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-dom-based-open-redirection@v1.0 defects=1}
function noncompliant() {
    let url = window.location.search.slice(1)
    // Noncompliant: Unsafe `JQuery` and `AJAX` request.
    $.ajax({url: url, data: "Hello"})
  }
// {/fact}