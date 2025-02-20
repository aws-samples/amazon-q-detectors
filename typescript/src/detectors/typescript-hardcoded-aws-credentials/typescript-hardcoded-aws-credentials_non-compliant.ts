// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hardcoded-aws-credentials@v1.0 defects=1}
import AWS from 'aws-sdk';

function nonCompliant(): void {
    const config = new AWS.Config({
        // Noncompliant: AWS credentials hardcoded.
        accessKeyId: "AWS_ACCESS_KEY_ID",
        secretAccessKey: "AWS_SECRET_ACCESS_KEY",
        sessionToken: "SESSION_TOKEN"
    });

    console.log('AWS Config successfully initialized:', config);
}
// {/fact}
