// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-allowlisted-ips@v1.0 defects=0}
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib';
import {
  CfnDomain as LegacyCfnDomain,
  ElasticsearchVersion,
} from 'aws-cdk-lib/aws-elasticsearch';
import {
  AccountRootPrincipal,
  Effect,
  PolicyDocument,
  PolicyStatement,
  Role,
} from 'aws-cdk-lib/aws-iam';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Specifies an `IpAddress` condition for access, restricting access to a specific IP address for added security.
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
