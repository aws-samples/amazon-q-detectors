// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-redshift-cluster-in-vpc@v1.0 defects=1}
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';
import {Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
	constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
		super(scope, id, props);    
       
        // Noncompliant: The CfnCluster instantiation does not set `clusterSubnetGroupName`. 
        new CfnCluster(Stack, 'rRedshiftCluster', {
            masterUsername: 'use_a_secret_here',
            masterUserPassword: os.environ.get('PASSWORD'),
            clusterType: 'single-node',
            dbName: 'bar',
            nodeType: 'ds2.xlarge',
            encrypted: true,
            port:42,
        });
    }
}
// {/fact}