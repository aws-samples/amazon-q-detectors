// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-x-frame-options-misconfiguration@v1.0 defects=0}
const express = require('express');
const app = express();

app.get('/ok-test', function (req, res) {
    // Compliant: Application correctly restricts frame objects.
    res.set('X-Frame-Options', 'SAMEORIGIN')
    res.send('ok')
})
// {/fact}
