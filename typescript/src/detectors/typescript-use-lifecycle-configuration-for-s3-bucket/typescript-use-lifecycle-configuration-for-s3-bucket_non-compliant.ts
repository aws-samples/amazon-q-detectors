// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=1}
import { Stack, StackProps, RemovalPolicy } from 'aws-cdk-lib';
import * as s3 from 'aws-cdk-lib/aws-s3';
import * as ec2 from 'aws-cdk-lib/aws-ec2';
import * as elbv2 from 'aws-cdk-lib/aws-elasticloadbalancingv2';
import { Construct } from 'constructs';

class CdkStack extends Stack {
    constructor(scope: Construct, id: string, props?: StackProps) {
        super(scope, id, props);

        // Noncompliant: Lifecycle rules not configured.
        const albAccessLogBucket = new s3.Bucket(this, 'access-log-bucket', {
            blockPublicAccess: s3.BlockPublicAccess.BLOCK_ALL,
            encryption: s3.BucketEncryption.S3_MANAGED,
            removalPolicy: RemovalPolicy.RETAIN,
            enforceSSL: true
        });

        const vpc = new ec2.Vpc(this, 'MyVPC', {
            maxAzs: 2
        });

        const publicSubnets = vpc.selectSubnets({
            subnetType: ec2.SubnetType.PUBLIC
        });

        const lbSecurityGroup = new ec2.SecurityGroup(this, 'LBSecurityGroup', {
            vpc,
            allowAllOutbound: true
        });

        const loadBalancer = new elbv2.ApplicationLoadBalancer(this, "LB", {
            vpc: vpc,
            vpcSubnets: { subnets: publicSubnets.subnets },
            internetFacing: true,
            securityGroup: lbSecurityGroup
        });
        loadBalancer.logAccessLogs(albAccessLogBucket, 'access-logs');
    }
}
// {/fact}