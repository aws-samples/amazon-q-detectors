// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-sns-no-bind-subscribe-publish@v1.0 defects=0}
import AWS from 'aws-sdk';

function compliant(res: { send: (data: any) => void }): void {
    const sns: AWS.SNS = new AWS.SNS({ apiVersion: '2010-03-31' });
    const params: { Protocol: string; TopicArn: string; Endpoint: string; ReturnSubscriptionArn: boolean } = {
        Protocol: 'STRING_VALUE',
        TopicArn: 'STRING_VALUE',
        Endpoint: 'STRING_VALUE',
        ReturnSubscriptionArn: true
    };

    // Compliant: Function contains only subscription logic.
    sns.subscribe(params, (err: Error | null, data: AWS.SNS.SubscribeResponse | null) => {
        if (err) {
            console.log(err);
        } else {
            console.log(data);
            res.send(data);
        }
    });
}
// {/fact}
