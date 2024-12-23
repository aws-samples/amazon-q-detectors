// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-sns-confirmsubscription-call@v1.0 defects=0}
import { SNS } from 'aws-sdk';
import SNSClient from 'aws-sdk/clients/sns';

const sns1: SNSClient = new SNSClient({
    region: 'us-west-2',
    apiVersion: '2014-10-01'
});

function compliant(): void {
    const sns: SNS = new SNS({ apiVersion: '2010-03-31' });
    
    const params: SNS.ConfirmSubscriptionInput = {
        Token: 'STRING_VALUE',
        TopicArn: 'STRING_VALUE',
        // Compliant: Subscription calls set the `AuthenticateOnUnsubscribe` to enabled.
        AuthenticateOnUnsubscribe: 'true'
    };

    sns.confirmSubscription(params, function(
        err: Error | null, 
        data: SNS.ConfirmSubscriptionResponse
    ): void {
        if (err) console.log(err, err.stack);
        else console.log(data);
    });
}
// {/fact}
