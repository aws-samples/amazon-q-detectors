// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-create-aws-service-client-inside-lambda-handler@v1.0 defects=1}
const AWS = require("aws-sdk");

exports.handler = function(event, context, callback) {
    // Noncompliant: AWS service client is created inside a Lambda function handler.
    const sqs = new AWS.SQS({apiVersion: '2012-11-05'});
    const params = {
        DelaySeconds: 10,
        MessageAttributes: {
            "Title": {
                DataType: "String",
                StringValue: "The Whistler"
            }
        }
    }

    sqs.sendMessage(params, function(err, data) {
        if (err) {
            console.log("Error", err);
        } else {
            console.log("Success", data.MessageId);
        }
    });
}
// {/fact}
