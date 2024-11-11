// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-aws-dynamodb-billing-mode@v1.0 defects=0}
import { AttributeType, BillingMode, Table } from 'aws-cdk-lib/aws-dynamodb';
import { Stack } from 'aws-cdk-lib/core';

// Compliant: The table instantiation sets `billingMode` to `BillingMode.PAY_PER_REQUEST`, allowing flexible capacity management.
new Table(Stack, 'MyTable', {
    partitionKey: { name: 'foo', type: AttributeType.STRING },
    billingMode: BillingMode.PAY_PER_REQUEST
});
// {/fact}
