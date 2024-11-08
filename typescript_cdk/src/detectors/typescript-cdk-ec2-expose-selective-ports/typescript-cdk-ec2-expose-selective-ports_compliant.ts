// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-cdk-ec2-expose-selective-ports@v1.0 defects=0}
import * as cdk from '@aws-cdk/core'
import { CfnSecurityGroupIngress, } from 'aws-cdk-lib/aws-ec2'
import {Stack} from 'aws-cdk-lib/core'

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Compliant: The CfnSecurityGroupIngress instantiation does not use the `0.0.0.0/0` range.
        new CfnSecurityGroupIngress(Stack, 'rIngress', {
            ipProtocol: 'tcp',
            cidrIp: '1.2.3.4/32',
        })
    }
}
// {/fact}
