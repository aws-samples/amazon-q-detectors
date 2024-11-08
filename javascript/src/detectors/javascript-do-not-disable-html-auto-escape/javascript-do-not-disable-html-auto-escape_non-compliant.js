// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-disable-html-auto-escape@v1.0 defects=1}
var kramed = require('kramed')

function doNotDisableHtmlAutoEscapeNoncompliant() {
    var setOptions = {
        renderer: new kramed.Renderer({
            // Noncompliant: Sanitize value is set as `false`.
            sanitize: false
        })
    }
}
// {/fact}
