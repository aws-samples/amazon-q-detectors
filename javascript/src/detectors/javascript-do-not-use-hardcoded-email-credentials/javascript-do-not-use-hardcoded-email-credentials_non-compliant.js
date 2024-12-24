// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-use-hardcoded-email-credentials@v1.0 defects=1}
const nodemailer = require("nodemailer");


function nonCompliant() {

    var name = "Some Name";
    var from = "me@gmail.com";
    var message = "This is a great message";
    var to = 'you@gmail.com';

    var smtpTransport = nodemailer.createTransport( {
        host: "smtp.gmail.com",
        port: 587,
        auth: {
            // Noncompliant: Hardcoded credentials are used when sending emails.
            user: "myname@gmail.com", 
            pass: "A Great Password"     
        }
    });

    var mailOptions = {
        from: from,
        to: to, 
        subject: name+' | new message !',
        text: message
    }

    smtpTransport.sendMail(mailOptions);
}
// {/fact}
