// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-data-exfilteration@v1.0 defects=1}
const express = require('express')
const app = express()

app.get("nonCompliant", (req, res) => {
    try {
        const targetObject = {};
        // Noncompliant: User control data is not being passed to `Object.assign`.
        let data = Object.assign(targetObject, req.query.data);
    }
    catch(err){
        console.log(err)
    }
    return res.end("ok");
});
// {/fact}
