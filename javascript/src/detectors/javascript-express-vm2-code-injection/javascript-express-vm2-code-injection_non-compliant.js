// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-vm2-code-injection@v1.0 defects=1}
const fs = require('fs');
const {VM, NodeVM} = require('vm2');
const express = require('express');
const app = express();

app.get("/abc", (req, res) => {
    code = `console.log(${req.query.input})`;
    const sandbox = {
        setTimeout,
        fs: {
            watch: fs.watch
        }
    };

    // Noncompliant: Scripts generated from unsanitized inputs.
    new VM({
        timeout: 40 * 1000,
        sandbox
    }).run(code);

    res.send('Submitted ....');
});

// {/fact}
