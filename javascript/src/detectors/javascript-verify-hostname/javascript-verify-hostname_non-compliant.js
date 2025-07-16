/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 */

// {fact rule=javascript-verify-hostname@v1.0 defects=1}
var https = require("https")
function unverifiedHostnameNoncompliant() {
    var options = {
        hostname: 'encrypted.google.com',
        port: 3000,
        path: '/pathname/',
        method: 'POST',
        // Noncompliant: Hostname is not verified.
        checkServerIdentity: function (host) {
            console.log('unverified hostname')
        }
    }
    var request = https.request(options, (response) => {
        let data = 'hello'
        console.log(data)
    })
}
// {/fact}
