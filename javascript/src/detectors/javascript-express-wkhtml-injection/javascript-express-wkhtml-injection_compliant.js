// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-express-wkhtml-injection@v1.0 defects=0}
const express = require('express')
const app = express()
const wkhtmltopdf = require('wkhtmltopdf')
const wkhtmltoimage = require('wkhtmltoimage')

app.get('/getpdf', async (req, res) => {
    const html = '<html></html>'
    // Compliant: No untrusted HTML is being used in `wkhtmltopdf` or `wkhtmltoimage`.
    const pdf = wkhtmltopdf(html, { output: 'vuln.pdf' })
    res.send(pdf)
})
// {/fact}
