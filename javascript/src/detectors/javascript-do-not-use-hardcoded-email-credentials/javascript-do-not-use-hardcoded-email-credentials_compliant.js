// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-use-hardcoded-email-credentials@v1.0 defects=0}
const nodemailer = require("nodemailer");


function compliant() {

    var from = "me@gmail.com";
    var message = "This is a great message";
    var to = 'you@gmail.com';

    // Compliant: Hardcoded credentials are not used when sending emails.
    var user = process.env.USER;    
    var pass = process.env.PASSWORD;

    var smtpTransport = nodemailer.createTransport({
        host: "smtp.gmail.com",
        port: 587,
        auth: {
            user: user,
            pass: pass
        }
    });

    var mailOptions = {
        from: from,
        to: to,
        subject: 'Some Subject',
        text: message
    }

    smtpTransport.sendMail(mailOptions);
}
// {/fact}
