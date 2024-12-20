// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-clear-text-protocol@v1.0 defects=1}
var nodemailerClient = require("nodemailer");

function nonCompliant(){
    // Noncompliant: Insecure connection setup due to missing enforcement of encryption.
    let transporter = nodemailerClient.createTransport({
        service: "gmail",
        auth: {user: process.env.EMAIL_USER, pass: process.env.EMAIL_PASS},
        secure: false
    });
}
// {/fact}
