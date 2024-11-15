// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-unsanitized-input-sendmail@v1.0 defects=0}
const express = require("express")
const app = express()
const axios = require('axios')
("use strict")
var nodemailer = require("nodemailer")
var smtpTransport = require('nodemailer-smtp-transport')

var transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
        user: "youremail@gmail.com",
        pass: "yourpassword",
    },
})

function compliant() {
    app.get("/query", function(req, res) {
        // Compliant: `encodeURIComponent` is used for encoding the HTML message safely before sending it.
        transporter.sendMail({
            from: "your_email",
            to: "your_receiver",
            subject: "your_subject",
            html: encodeURIComponent(req.params.html_msg)
        })
    })
}
// {/fact}
