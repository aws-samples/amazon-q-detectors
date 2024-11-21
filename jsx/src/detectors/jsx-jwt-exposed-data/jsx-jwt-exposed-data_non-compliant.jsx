// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-jwt-exposed-data@v1.0 defects=1}
var jwt = require("jsonwebtoken")

function noncompliant() {
    User.findOne({ email: req.body.email }, function (e, user) {
        // Noncompliant: Object is passed directly to `jsonwebtoken.sign()` without any validation.
        var token = jwt.sign(user, key, { expiresIn: 60 * 60 * 10 })
        return token
    })
}
// {/fact}
