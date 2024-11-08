/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=javascript-verify-hostname@v1.0 defects=0}
var https = require("https")
function unverifiedHostnameCompliant() {
    var options = {
        hostname: 'encrypted.google.com',
        port: 3000,
        path: '/pathname/',
        method: 'POST',
        // Compliant: Hostname is verified before using it.
        checkServerIdentity: function (host) {
            if (host != "github.com") {
                console.log('verified hostname')
            }
        }
    }
    var request = https.request(options, (response) => {
        let data = 'hello'
        console.log(data)
    })
}
// {/fact}
