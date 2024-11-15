// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-express-data-exfilteration@v1.0 defects=0}
const express = require('express')
const app = express()

function compliant(req, res) {
    try {
        const targetObject = {}
        // Compliant: Using `Object.assign` safely with a new target object.
        let data = Object.assign(targetObject, _.pick(req.query, 'allowField01', 'allowField02'))
    } catch (err) {
        console.log(err)
    }
    res.end("ok")
}
// {/fact}
