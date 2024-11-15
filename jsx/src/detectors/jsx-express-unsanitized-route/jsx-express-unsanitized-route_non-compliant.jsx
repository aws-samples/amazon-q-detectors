// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-unsanitized-route@v1.0 defects=1}
const express = require('express')
const { body } = require('express-validator')
const app = express()

function noncompliant() {
    app.route('/user/:id')
        .get((req, res) => {
            let id_ = req.params.id
            str1 = id_ + `
            <form method="POST" style="margin: 60px auto; width: 140px;">
                <p><input name="username" type="text" /></p>
                <p><input name="password" type="password" /></p>
                <p><input value="Login" type="submit" /></p>
            </form>
            `
            // Non-compliant: User input is not sanitized, leading to potential XSS.
            res.send(str1)
        })
}
// {/fact}
