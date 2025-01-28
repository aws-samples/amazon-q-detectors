// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-use-raw-html-in-join@v1.0 defects=1}
function nonCompliant(data: string): void {
    // Noncompliant: Raw HTML is used in `join()`, creating a potential security vulnerability.
    let html = ["<span class=\"someclass\">", data, "</span>"].join();
}
// {/fact}
