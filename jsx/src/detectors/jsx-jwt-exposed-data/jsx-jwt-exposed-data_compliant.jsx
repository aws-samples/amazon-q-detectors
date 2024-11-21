// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0


// {fact rule=jsx-jwt-exposed-data@v1.0 defects=0}
var jwt = require("jsonwebtoken")

function compliant() {
    User.findOne({ name: req.body.name }, function (err, user) {
        if (err || !user) {
            throw new Error("Invalid user")
        }
        // Compliant: Validated `name` before passing into `jsonwebtoken.sign()`.
        var token = jwt.sign({ name: user.name }, key, { expiresIn: 60 * 60 * 10 })
        return token
    })
}
// {/fact}