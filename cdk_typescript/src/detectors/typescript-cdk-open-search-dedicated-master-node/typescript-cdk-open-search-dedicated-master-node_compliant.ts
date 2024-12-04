// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-dedicated-master-node@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import {
  Domain as LegacyDomain,
  ElasticsearchVersion
} from 'aws-cdk-lib/aws-elasticsearch';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Specifies`masterNodes` capacity, ensuring sufficient resources for the Elasticsearch cluster.
    new LegacyDomain(Stack, 'Domain', {
      version: ElasticsearchVersion.V7_10,
      capacity: { masterNodes: 42 }
    });
  }
}
// {/fact}
