// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-create-aws-service-client-inside-lambda-handler@v1.0 defects=0}
const AWS = require("aws-sdk");

// Complaint: AWS service client is created outside a Lambda function handler.
const s3 = new AWS.S3();
exports.handler = function (event, context, callback) {
    s3.listBuckets(null, callback)
    setTimeout(function () {
        console.log('Timeout complete.')
    }, 5000);
}
// {/fact}
