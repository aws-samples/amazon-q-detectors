// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-use-raw-html-in-join@v1.0 defects=1}
const jquery = require("jquery");

function nonCompliant(data)
{
    // Noncompliant: Raw html is used in `join()`.
    let html = ["<span class=\"someclass\">", data, "</span>"].join();
}
// {/fact}
