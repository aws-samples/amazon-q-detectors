// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-override-lambda-env-var@v1.0 defects=0}
const aws = require('aws-sdk');

exports.handler =  async function(event, context) {
    console.log("EVENT: \n" + JSON.stringify(event, null, 2))

    compliant();
    return context.logStreamName;
}

function compliant()
{
    // Compliant: Environment variables reserved by the Lambda runtime environment are not overwritten.
    process.env.APP_REGION = "us-east-1";

    return {
        statusCode: 200,
        body: JSON.stringify(event)
    };
}
// {/fact}
