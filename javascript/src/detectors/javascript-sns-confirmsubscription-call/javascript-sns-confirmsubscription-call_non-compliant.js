// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sns-confirmsubscription-call@v1.0 defects=1}
function nonCompliant() {
    let AWS = require('aws-sdk');
    let sns = new AWS.SNS({apiVersion: '2010-03-31'});
    let params = {
        Token: 'STRING_VALUE', 
        TopicArn: 'STRING_VALUE', 
        // Noncompliant: Subscription calls set the `AuthenticateOnUnsubscribe` to disabled.
        AuthenticateOnUnsubscribe: 'false'
    };
    sns.confirmSubscription(params, function(err, data) {
        if (err) console.log(err, err.stack); 
        else     console.log(data);  
    });
}
// {/fact}
