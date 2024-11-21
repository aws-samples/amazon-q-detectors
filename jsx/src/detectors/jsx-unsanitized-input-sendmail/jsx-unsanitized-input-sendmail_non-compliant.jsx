// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved. 
// SPDX-License-Identifier: MIT-0

// {fact rule=jsx-unsanitized-input-sendmail@v1.0 defects=1}
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

function noncompliant() {
  app.get("/query", function (req, res) {
    // Noncompliant: `html` field is directly populated with user input without sanitization, making it vulnerable to XSS attacks.
    transporter.sendMail({
      from: "your_email",
      to: "your_receiver",
      subject: "your_subject",
      html: req.params.html_msg,
    })
  })
}
// {/fact}
