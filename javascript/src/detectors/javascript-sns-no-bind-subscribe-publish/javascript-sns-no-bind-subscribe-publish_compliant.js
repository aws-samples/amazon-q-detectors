// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sns-no-bind-subscribe-publish@v1.0 defects=0}
function complaint() {
    let AWS = require('aws-sdk');
    let sns = new AWS.SNS({apiVersion: '2010-03-31'});
    let params = {
        Protocol: 'STRING_VALUE', 
        TopicArn: 'STRING_VALUE',
        Endpoint: 'STRING_VALUE',
        ReturnSubscriptionArn: true
    };

    // Compliant: Function contains only subscription logic.
    sns.subscribe(params, (err, data) => {
        if (err) {
            console.log(err);
        } else {
            console.log(data);
            res.send(data);
        }
    });
}
// {/fact}
