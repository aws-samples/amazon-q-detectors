// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-do-not-disable-html-auto-escape@v1.0 defects=1}
var kramed = require('kramed')

function noncompliant() {
    var setOptions = {
        renderer: new kramed.Renderer({
            // Noncompliant: Sanitize value is set as `false`.
            sanitize: false
        })
    }
}
// {/fact}
