// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-vm2-code-injection@v1.0 defects=0}
const fs = require('fs');
const {VM, NodeVM} = require('vm2');
const express = require('express');
const app = express();
var sanitizer = require('sanitize');

function sanitize(input) {
    return sanitizer.value(input, ['alpha', 'numeric', 'dashes']);
}

app.get('/www', async function (req, res) {
    sanitizedInput = sanitize(req.query.input);
    code = `console.log(${sanitizedInput})`;

    const sandbox = {
        setTimeout,
        fs: {
            watch: fs.watch
        }
    };

    // Compliant: Scripts generated from pre decided input templates which does not have external data.
    const vmResult = new VM({
        timeout: 40 * 1000,
        sandbox
    }).run(code);

    res.send('Submitted ....');
});
// {/fact}
