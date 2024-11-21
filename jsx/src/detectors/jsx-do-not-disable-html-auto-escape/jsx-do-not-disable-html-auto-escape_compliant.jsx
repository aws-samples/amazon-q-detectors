// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-disable-html-auto-escape@v1.0 defects=0}
var kramed = require('kramed')

function compliant() {
    var setOptions = {
        renderer: new kramed.Renderer({
            // Compliant: Sanitize is `true` by default.
        })
    }
}
// {/fact}
