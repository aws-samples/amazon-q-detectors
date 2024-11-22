// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-eks-cluster-control-plane-logs@v1.0 defects=0}
import {
  Cluster,
  ClusterLoggingTypes,
  EndpointAccess,
  KubernetesVersion
} from 'aws-cdk-lib/aws-eks';
import { Stack } from 'aws-cdk-lib';
import * as cdk from 'aws-cdk-lib';
    
export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);      
    // Compliant: Uses private endpoint access and enables comprehensive cluster logging for security and auditing.
    new Cluster(Stack, 'rCustomEKS', {
      version: KubernetesVersion.V1_14,
      endpointAccess: EndpointAccess.PRIVATE,
      clusterLogging: [
        ClusterLoggingTypes.API,
        ClusterLoggingTypes.AUDIT,
        ClusterLoggingTypes.AUTHENTICATOR,
        ClusterLoggingTypes.CONTROLLER_MANAGER,
        ClusterLoggingTypes.SCHEDULER
      ]
    });
  }
}
// {/fact}
