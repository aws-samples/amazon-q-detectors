// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-sns-no-bind-subscribe-publish@v1.0 defects=1}
import AWS from 'aws-sdk';

const sns: AWS.SNS = new AWS.SNS({ apiVersion: '2010-03-31' });

const topicInfo: AWS.SNS.CreateTopicResponse = await sns.createTopic({ Name: 'TEST_TOPIC_NAME' }).promise();
const params: AWS.SNS.SubscribeInput = {
    Protocol: 'STRING_VALUE',
    TopicArn: topicInfo.TopicArn as string,
    Endpoint: 'STRING_VALUE',
    ReturnSubscriptionArn: true
};

// Noncompliant: SNS subscription and publish tightly coupled.
sns.subscribe(params, (err: Error | null, data: AWS.SNS.SubscribeResponse | null) => {
    if (err) {
        console.log(err);
    } else {
        console.log(data);
        res.send(data);
    }
});

const params1: AWS.SNS.PublishInput = {
    Message: 'STRING_VALUE',
    Subject: 'STRING_VALUE',
    TopicArn: topicInfo.TopicArn as string
};

sns.publish(params1, (err: Error | null, data: AWS.SNS.PublishResponse | null) => {
    if (err) console.log(err, err.stack);
    else console.log(data);
});
// {/fact}
