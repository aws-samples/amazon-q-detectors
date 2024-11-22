// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-emr-auth-ec-2-key-pair-or-kerberos@v1.0 defects=0}
import { CfnCluster} from 'aws-cdk-lib/aws-emr';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';


export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
	super(scope, id, props);   
    // Compliant: Configures Kerberos authentication, enhancing security for the EMR cluster.
    new CfnCluster(Stack, 'rEmrCluster', {
      instances: {},
      jobFlowRole: ' EMR_EC2_DefaultRole',
      name: 'foo',
      serviceRole: 'bar',
      kerberosAttributes: {
        kdcAdminPassword: 'baz',
        realm: 'qux'
      }
    });
  }
}
// {/fact}
