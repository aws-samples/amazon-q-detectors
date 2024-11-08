// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-prototype-pollution-assignment@v1.0 defects=0}
var express = require('express')
var app = express()
function insecureObjectAttributeModificationCompliant() {
    app.get('www.example.com', (req, res) => {
        var userId = req.params.id
        // Compliant: Checks that `userId` is a string and not `proto` or `constructor` to prevent prototype pollution.
        if (typeof userId === 'string' && !['proto', 'constructor'].includes(userId)) {
            req.session.user[userId] = req.body['userDetails']
        }
    });
}
// {/fact}
