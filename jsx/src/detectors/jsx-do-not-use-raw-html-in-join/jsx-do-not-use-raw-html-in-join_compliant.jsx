// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-use-raw-html-in-join@v1.0 defects=0}
function compliant(data1, data2) {
    const escapeHtml = str => str.replace(/[&<>"'`=\/]/g, char =>
        ({ '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;', '`': '&#96;', '=': '&#61;', '/': '&#47;' }[char])
    )
    // Compliant: Raw HTML is not used in `join()`.
    const x = [escapeHtml(data1), escapeHtml(data2)].join()
}
// {/fact}