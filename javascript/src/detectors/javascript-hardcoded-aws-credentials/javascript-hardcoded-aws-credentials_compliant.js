// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hardcoded-aws-credentials@v1.0 defects=0}
const AWS = require('aws-sdk');
const cy = require('cypress');

function compliant() {
    let accessKey, secretKey, session;

    // Complaint: AWS credentials are not hardcoded.
    cy.readFile('sdkConfig.json').then(cfg_var => {
        accessKey = cfg_var.AWS_ACCESS_KEY_ID;
        secretKey = cfg_var.AWS_SECRET_ACCESS_KEY;
        session = cfg_var.SESSION_TOKEN;

        const cfg = new AWS.Config({
            accessKeyId: accessKey,
            secretAccessKey: secretKey,
            sessionToken: session
        });

        console.log('AWS Config successfully initialized:', cfg);
    });
}

// {/fact}
