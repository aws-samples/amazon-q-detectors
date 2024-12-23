// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-s3-copy-bucket-owner@v1.0 defects=0}
const AWS = require('aws-sdk');
const s3 = new AWS.S3();

var params = {
    Bucket: "destinationbucket", // Destination bucket
    CopySource: "/sourcebucket/HappyFacejpg", // Source bucket and object
    Key: "HappyFaceCopyjpg", // Destination key (name of copied object)
    ExpectedBucketOwner: "123456789012", // AWS account ID of the destination bucket owner
    ExpectedSourceBucketOwner: "098765432109" // AWS account ID of the source bucket owner
};

// Compliant: `ExpectedBucketOwner` and `ExpectedSourceBucketOwner` properties have been correctly set.
s3.copyObject(params, function(err, data) {
    if (err) {
        console.log("Error:", err, err.stack);
    } else {
        console.log("Success:", data);
    }
});
// {/fact}
