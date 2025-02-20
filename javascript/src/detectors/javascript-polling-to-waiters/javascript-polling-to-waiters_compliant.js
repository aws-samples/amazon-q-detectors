// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-polling-to-waiters@v1.0 defects=0}
let AWS = require('aws-sdk');
let S3 = require('aws-sdk/clients/s3');
let s3 = new S3();
let cf = new AWS.CloudFormation();

function compliant(bucketName, cb) {
    let s3 = new AWS.S3();
    let paramsCreate = {
        Bucket: bucketName
    };

    s3.createBucket(paramsCreate, function (err, data) {
        if (err && err.code !== 'BucketAlreadyOwnedByYou' && err.code !== 'BucketAlreadyExists') {
            console.log(err, err.stack);
        }

        let paramsWait = {
            Bucket: bucketName
        };

        // Compliant: Verify bucket created before performing other operations on bucket
        s3.waitFor('bucketExists', paramsWait, function (err, data) {
            if (err) {
                console.log(err, err.stack);
                return cb({code: 502, message: `Failed to create bucket ${bucketName}.`}, null);
            }

            return cb(null, {code: 200, message: `Bucket ${bucketName} created.`});
        });
    });
};
// {/fact}
