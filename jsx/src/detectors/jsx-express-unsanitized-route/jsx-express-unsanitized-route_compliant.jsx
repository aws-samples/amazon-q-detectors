// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-unsanitized-route@v1.0 defects=0}
const express = require('express')
const { body } = require('express-validator')
const app = express()

function escape(str) {
    return str.replace(/&/g, "&amp;")
              .replace(/</g, "&lt;")
              .replace(/>/g, "&gt;")
              .replace(/"/g, "&quot;")
              .replace(/'/g, "&#039;")
}

function compliant() {
    app.route('/user/:id')
        .get((req, res) => {
            let id_ = escape(req.params.id)
            let str1 = id_ + `
        <form method="POST" style="margin: 60px auto; width: 140px;">
            <p><input name="username" type="text" /></p>
            <p><input name="password" type="password" /></p>
            <p><input value="Login" type="submit" /></p>
        </form>
        `
            // Compliant: User input is sanitized with `escape()` to prevent XSS.
            res.send(str1)
        })
}

// {/fact}
