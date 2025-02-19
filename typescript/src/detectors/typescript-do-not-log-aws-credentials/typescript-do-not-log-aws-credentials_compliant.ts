// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-log-aws-credentials@v1.0 defects=0}
import AWS from 'aws-sdk';
import log4js from 'log4js';

const logger = log4js.getLogger();

function compliant(): void {
    const sts_client: AWS.STS = new AWS.STS();

    sts_client.assumeRole({
        RoleArn: "arn:aws:iam::account-of-role-to-assume:role/name-of-role",
        RoleSessionName: "AssumeRoleSession1",
    }, (err: AWS.AWSError, assumed_role_object: AWS.STS.AssumeRoleResponse) => {
        if (err) {
            console.error("Error assuming role:", err);
            return;
        }
        if (assumed_role_object && assumed_role_object.Credentials) {
            const credentials = assumed_role_object.Credentials;
            const accessKeyId: string | undefined = credentials.AccessKeyId;
            const secretAccessKey: string | undefined = credentials.SecretAccessKey;
            // Compliant: AWS Credentials are not logged.
            logger.info("Assumed role successfully.");
        }
    });
}
// {/fact}
