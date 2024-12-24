// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-use-lifecycle-configuration-for-s3-bucket@v1.0 defects=0}
import { Stack, StackProps, RemovalPolicy, Duration } from 'aws-cdk-lib';
import * as s3 from 'aws-cdk-lib/aws-s3';
import * as elbv2 from 'aws-cdk-lib/aws-elasticloadbalancingv2';
import { Construct } from 'constructs';

class CdkStack extends Stack {
    constructor(scope: Construct, id: string, props?: StackProps) {
        super(scope, id, props);

        const albAccessLogBucket = new s3.Bucket(this, 'access-log-bucket', {
            blockPublicAccess: s3.BlockPublicAccess.BLOCK_ALL,
            encryption: s3.BucketEncryption.S3_MANAGED,
            removalPolicy: RemovalPolicy.RETAIN,
            enforceSSL: true
        });

        // Compliant: Lifecycle rules have been configured.
        albAccessLogBucket.addLifecycleRule({
            prefix: 'logs/',
            expiration: Duration.days(90),
            transitions: [
                {
                    storageClass: s3.StorageClass.ONE_ZONE_INFREQUENT_ACCESS,
                    transitionAfter: Duration.days(60),
                },
            ],
        });

        const vpc = /* define your VPC here */;
        const publicSubnets = /* define your public subnets here */;
        const lbSecurityGroup = /* define your security group here */;

        const loadBalancer = new elbv2.ApplicationLoadBalancer(this, "LB", {
            vpc: vpc,
            vpcSubnets: { subnets: publicSubnets },
            internetFacing: true,
            securityGroup: lbSecurityGroup
        });
        loadBalancer.logAccessLogs(albAccessLogBucket, 'access-logs');
    }
}
// {/fact}
