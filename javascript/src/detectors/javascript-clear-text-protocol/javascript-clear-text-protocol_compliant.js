// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-clear-text-protocol@v1.0 defects=0}
var nodemailerClient = require("nodemailer");

function compliant(){
    // Compliant: Ensures secure communication by using encryption with the `secure: true` option.
    let transporter = nodemailerClient.createTransport({
        service: "gmail",
        auth: { user: process.env.EMAIL_USER, pass: process.env.EMAIL_PASS },
        secure: true,
    });
}
// {/fact}
