// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-do-not-log-aws-credentials@v1.0 defects=1}
import AWS from 'aws-sdk';
import log from 'npmlog';
import log4js from 'log4js';
import os from 'os';

const logger = log4js.getLogger();

function nonCompliant(): void {
    const sts_client = new AWS.STS();
    sts_client.assumeRole({
        RoleArn: "arn:aws:iam::account-of-role-to-assume:role/name-of-role",
        RoleSessionName: "AssumeRoleSession1"
    }, (err, assumed_role_object) => {
        if (err) {
            console.error("Error assuming role:", err);
            return;
        }
        if (assumed_role_object && assumed_role_object.Credentials) {
            const credentials = assumed_role_object.Credentials;
            // Noncompliant: AWS credentials are logged.
            log.info('SecretAccessKey', credentials.SecretAccessKey);
        }
    });
}
// {/fact}
