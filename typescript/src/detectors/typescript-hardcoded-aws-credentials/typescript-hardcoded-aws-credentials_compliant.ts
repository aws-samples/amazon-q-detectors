// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-2.0

// {fact rule=typescript-hardcoded-aws-credentials@v1.0 defects=0}
import AWS from 'aws-sdk';

function compliant(): void {
    const config = new AWS.Config({
        // Compliant: Credentials loaded from environment variables.
        accessKeyId: process.env.AWS_ACCESS_KEY_ID,
        secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY,
        sessionToken: process.env.AWS_SESSION_TOKEN
    });

    console.log('AWS Config successfully initialized:', config);
}
// {/fact}
