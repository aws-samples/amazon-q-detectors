// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sns-subscribe-return-subscription-arn@v1.0 defects=0}
function compliant(lambdaArn,SnsTopicArn,DlqArn)
{
    const AWS = require('aws-sdk');
    const SNS = new AWS.SNS();
    const params = {
        Protocol: "lambda",
        TopicArn: SnsTopicArn,
        Endpoint: lambdaArn,
        // Compliant: `ReturnSubscriptionArn` is enabled.
        ReturnSubscriptionArn: true,   
        Attributes: {
            RedrivePolicy: DlqArn,
        }
    }

    const response =  SNS.subscribe(params).promise();
}
// {/fact}
