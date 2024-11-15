// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-avoid-disabling-vue-sanitization@v1.0 defects=1}
const Vue = require("vue")

function noncompliant() {
    Vue.component('custom-element', {
        render: h => h('elementId', {
            domProps: {
                // Noncompliant: Using `innerHTML` with unsanitized user input enables XSS attacks through direct HTML injection.
                innerHTML: "<h1>Hey " + name + "</h1>" 
            }
        }, "click here2")
    })
}
// {/fact}
