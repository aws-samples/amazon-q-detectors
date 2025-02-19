// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-override-lambda-env-var@v1.0 defects=1}
const aws = require('aws-sdk');

exports.handler =  async function(event, context) {
    console.log("EVENT: \n" + JSON.stringify(event, null, 2))

    nonCompliant();

    return context.logStreamName;
}
function nonCompliant()
{
    // Noncompliant: Environment variables reserved by the Lambda runtime environment are overwritten.
    process.env.AWS_REGION = "us-east-1";

    return {
        statusCode: 200,
        body: JSON.stringify(event)
    };
}
// {/fact}
