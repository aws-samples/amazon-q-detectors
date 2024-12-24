// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-data-exfilteration@v1.0 defects=0}
const express = require('express')
const app = express()

function compliant() {
    try {
        const targetObject = {};
        // Compliant: User control data is not being passed to `Object.assign`.
        let data = Object.assign(targetObject, {a : 10});
    }
    catch(err){
        console.log(err)
    }
    res.end("ok");
}
// {/fact}
