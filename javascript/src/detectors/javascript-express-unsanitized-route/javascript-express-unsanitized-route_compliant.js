// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-unsanitized-route@v1.0 defects=0}
const express = require('express');
const escapeHtml = require('escape-html'); // Import the package

const app = express();

app.route('/user/:id')
    .get((req, res) => {
        // Compliant: User input is escaped to prevent XSS.
        let id_ = escapeHtml(req.params.id);
        const str1 = id_ + `
            <form method="POST" style="margin: 60px auto; width: 140px;">
                <p><input name="username" type="text" /></p>
                <p><input name="password" type="password" /></p>
                <p><input value="Login" type="submit" /></p>
            </form>
        `;
        res.send(str1);
});
// {/fact}
