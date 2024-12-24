// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-sns-confirmsubscription-call@v1.0 defects=1}
import { SNS } from 'aws-sdk';

function nonCompliant(): void {
    const sns: SNS = new SNS({ apiVersion: '2010-03-31' });
    
    const params: SNS.ConfirmSubscriptionInput = {
        Token: 'STRING_VALUE',
        TopicArn: 'STRING_VALUE',
        // Noncompliant: Subscription calls set the `AuthenticateOnUnsubscribe` to disabled.
        AuthenticateOnUnsubscribe: 'false'
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
