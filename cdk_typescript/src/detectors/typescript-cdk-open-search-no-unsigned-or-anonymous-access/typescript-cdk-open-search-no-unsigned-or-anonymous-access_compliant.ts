// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-no-unsigned-or-anonymous-access@v1.0 defects=0}
import {
  CfnDomain as LegacyCfnDomain,
  ElasticsearchVersion
} from 'aws-cdk-lib/aws-elasticsearch';
import {
  AccountRootPrincipal,
  Effect,
  PolicyDocument,
  PolicyStatement,
  Role,
} from 'aws-cdk-lib/aws-iam';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Includes an `IpAddress` condition, restricting access to a specific IP address for better security.
    new LegacyCfnDomain(Stack, 'Domain', {
      elasticsearchVersion: ElasticsearchVersion.V7_10.version,
      accessPolicies: new PolicyDocument({
        statements: [
          new PolicyStatement({
            effect: Effect.ALLOW,
            principals: [
              new Role(Stack, 'Role', {
                assumedBy: new AccountRootPrincipal(),
              }),
            ],
            resources: ['*'],
            conditions: {
              IpAddress: {
                'aws:sourceIp': ['42.42.42.42']
              }
            }
          })
        ]
      }).toJSON()
    });
  }
}
// {/fact}
