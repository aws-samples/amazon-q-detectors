// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-eks-public-access-enabled@v1.0 defects=1}
import * as cdk from 'aws-cdk-lib';
import {
  Cluster,
  EndpointAccess,
  KubernetesVersion,
} from "aws-cdk-lib/aws-eks";
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Noncompliant: Cluster instantiation sets `endpointAccess` to `EndpointAccess.PUBLIC`.
    new Cluster(Stack, "rCustomEKS", {
      version: KubernetesVersion.V1_14,
      endpointAccess: EndpointAccess.PUBLIC,
    });
   
  }
}
// {/fact}