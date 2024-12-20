// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sns-no-bind-subscribe-publish@v1.0 defects=1}
let AWS = require('aws-sdk');
let sns = new AWS.SNS({apiVersion: '2010-03-31'});

let topic_info = sns.create_topic(Name='TEST_TOPIC_NAME')
let params = {
    Protocol: 'STRING_VALUE',
    TopicArn: topic_info['STRING_VALUE'],
    Endpoint: 'STRING_VALUE',
    ReturnSubscriptionArn: true
};

// Noncompliant: SNS subscription and publish tightly coupled.
sns.subscribe(params, (err, data) => {
    if (err) {
        console.log(err);
    } else {
        console.log(data);
        res.send(data);
    }
});

let params1 = {
    Message: 'STRING_VALUE',
    Subject: 'STRING_VALUE',
    TopicArn: topic_info['STRING_VALUE']
};

sns.publish(params1, function(err, data) {
    if (err) console.log(err, err.stack);
    else console.log(data);
});
// {/fact}
