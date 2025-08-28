/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 */

// {fact rule=jsx-verify-hostname@v1.0 defects=0}
var https = require("https")

function compliant() {
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
