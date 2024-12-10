// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hardcoded-aws-credentials@v1.0 defects=1}
const AWS = require('aws-sdk');

function nonCompliant(){

    const config = new AWS.Config({
        // Noncompliant: AWS credentials not hardcoded.
        accessKeyId: "AWS_ACCESS_KEY_ID",
        secretAccessKey: "AWS_SECRET_ACCESS_KEY",
        sessionToken: "SESSION_TOKEN"
    });

    console.log('AWS Config successfully initialized:', cfg);
}
// {/fact}
