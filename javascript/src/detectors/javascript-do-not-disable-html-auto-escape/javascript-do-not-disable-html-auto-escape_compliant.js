// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-disable-html-auto-escape@v1.0 defects=0}
var kramed = require('kramed')

function doNotDisableHtmlAutoEscapeCompliant() {
    var setOptions = {
        renderer: new kramed.Renderer({
            // Compliant: Sanitize is `true` by default.
        })
    }
}
// {/fact}
