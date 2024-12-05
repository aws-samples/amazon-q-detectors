// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-open-search-no-unsigned-or-anonymous-access@v1.0 defects=1}
import { Vpc } from 'aws-cdk-lib/aws-ec2';
import {
  CfnDomain as LegacyCfnDomain,
  ElasticsearchVersion
} from 'aws-cdk-lib/aws-elasticsearch';
import {
  AnyPrincipal,
  Effect,
  PolicyDocument,
  PolicyStatement
} from 'aws-cdk-lib/aws-iam';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Uses `AnyPrincipal()` with no access restrictions, potentially allowing unrestricted access to the Elasticsearch domain.
    new LegacyCfnDomain(Stack, 'Domain', {
      elasticsearchVersion: ElasticsearchVersion.V7_10.version,
      accessPolicies: new PolicyDocument({
        statements: [
          new PolicyStatement({
            effect: Effect.ALLOW,
            principals: [new AnyPrincipal()],
            resources: ['*']
        })
        ]
      }).toJSON()
    });
  }
}
// {/fact}
