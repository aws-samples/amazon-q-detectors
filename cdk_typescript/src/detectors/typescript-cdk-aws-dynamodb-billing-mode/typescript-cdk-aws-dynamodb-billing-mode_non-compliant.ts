// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-aws-dynamodb-billing-mode@v1.0 defects=1}
import { AttributeType, BillingMode, Table } from 'aws-cdk-lib/aws-dynamodb';
import { Stack } from 'aws-cdk-lib/core';

// Noncompliant: `billingMode` is not set.
new Table(Stack, 'rTable', {
	partitionKey: { name: 'foo', type: AttributeType.STRING },
});
// {/fact}