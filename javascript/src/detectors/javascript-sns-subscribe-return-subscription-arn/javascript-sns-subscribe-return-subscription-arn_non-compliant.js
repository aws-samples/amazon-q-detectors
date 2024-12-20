// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sns-subscribe-return-subscription-arn@v1.0 defects=1}
let aws = require("aws-sdk")
function nonCompliant() {

    let aws = require("aws-sdk")
    const sns = new aws.SNS();


    // Noncompliant: `ReturnSubscriptionArn` is disabled.
    const subscriptionArn = sns.subscribe({
            Protocol : "lambda",
            TopicArn : this.topicArn   
        }
    );
}
// {/fact}
