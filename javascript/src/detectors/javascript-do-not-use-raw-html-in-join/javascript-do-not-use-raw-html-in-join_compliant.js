// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-use-raw-html-in-join@v1.0 defects=0}
const jquery = require("jquery");

function compliant(data1, data2)
{
    // Compliant: Raw html is not used in `join()`.
    const x = [data1, data2].join();
}
// {/fact}
