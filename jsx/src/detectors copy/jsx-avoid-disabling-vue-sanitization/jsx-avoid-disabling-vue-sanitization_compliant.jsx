// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-avoid-disabling-vue-sanitization@v1.0 defects=0}
const Vue = require("vue");
const DOMPurify = require("dompurify");

function compliant(name) {
    Vue.component('custom-element', {
        render: h => h('elementId', {
            domProps: {
                // Compliant: Sanitizing user input to prevent XSS attacks.
                innerHTML: DOMPurify.sanitize("<h1>Hey " + name + "</h1>")
            }
        }, "click here2")
    });
}
// {/fact}