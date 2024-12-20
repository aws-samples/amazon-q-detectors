// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-polling-to-waiters@v1.0 defects=1}
let AWS = require('aws-sdk');
let S3 = require('aws-sdk/clients/s3');
let s3 = new S3();
let cf = new AWS.CloudFormation();

function nonCompliant(bucketName, bucketRegion) {
    return (dispatch) => {
        s3
            .createBucket({
                Bucket: bucketName,
                ...(bucketRegion !== "us-east-1" && {
                    CreateBucketConfiguration: {
                        LocationConstraint: bucketRegion,
                    },
                }),
            })
            .promise()
            .then((res) => {
                dispatch(actionSuccess("SUCCESS", {...res, bucketName}));
            })
            .catch((err) => {
                console.log("error", err);
                dispatch(actionError("ERROR", err.message));
            });

        let cb = setInterval(() => {
            // Noncompliant: Custom polling is inefficient and prone to error.
            if(s3.headBucket())
                clearInterval(cb);
        }, 20000);
    };
}
// {/fact}