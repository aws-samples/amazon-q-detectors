// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-slow-logs-to-cloud-watch@v1.0 defects=0}
import {
Domain as LegacyDomain,
ElasticsearchVersion,
} from 'aws-cdk-lib/aws-elasticsearch';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);   
    // Compliant: Enables logging for better monitoring.
    new LegacyDomain(Stack, 'Domain', {
      version: ElasticsearchVersion.V7_10,
      logging: { slowIndexLogEnabled: true, slowSearchLogEnabled: true }
    });
	}
}
// {/fact}
